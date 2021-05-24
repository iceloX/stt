package com.aiit.controller;

import com.aiit.config.quartz.DynamicTaskConfig;
import com.aiit.pojo.Sign;
import com.aiit.pojo.User;
import com.aiit.service.IActivityService;
import com.aiit.service.ICommunityService;
import com.aiit.service.ISignService;
import com.aiit.service.IUserService;
import com.aiit.utils.date.DateUtil;
import com.aiit.utils.distance.DistanceUtil;
import com.aiit.utils.qrcode.QRCodeUtil;
import com.aiit.utils.quartz.CronDateUtils;
import com.aiit.utils.returns.CommonEnum;
import com.aiit.utils.returns.JsonResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


/**
 * @Author icelo
 * @Date 2021/5/6
 * @Descriptions
 */

@RestController
@CrossOrigin
@RequestMapping("sign")
public class SignController {

    ISignService signService;

    ICommunityService communityService;

    DynamicTaskConfig dynamicTaskConfig;

    IActivityService activityService;

    IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setActivityService(IActivityService activityService) {
        this.activityService = activityService;
    }

    @Autowired
    public void setDynamicTaskConfig(DynamicTaskConfig dynamicTaskConfig) {
        this.dynamicTaskConfig = dynamicTaskConfig;
    }

    @Autowired
    public void setCommunityService(ICommunityService communityService) {
        this.communityService = communityService;
    }

    @Autowired
    public void setSignService(ISignService signService) {
        this.signService = signService;
    }

    /**
     * 查询所有还没有开始的签到，将所有的签到都加入的任务处理当中
     *
     * @return
     */
    @GetMapping("/all")
    public JsonResult getAllSign() {
        List<Sign> signs = signService.list();
        for (Sign sign : signs) {
            if (LocalDateTime.now().isBefore(sign.getBegin()))  // 遍历所有签到，在开始之前的签到都开启一个新线程
                new Thread(() -> {
                    String taskName = sign.getName();
                    // 将数据库中保存的开始时间转化为cron表达式
                    String cron = CronDateUtils.getCron(DateUtil.loca2Date(sign.getBegin()));
                    dynamicTaskConfig.startCron(taskName, () -> {
                        try {
                            String code = QRCodeUtil.getQRCodeBase64(String.valueOf(sign.getId()));
                            System.out.println(code);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }, cron);
                }).start();
        }
        return JsonResult.success(signs);
    }

    /**
     * 用户完成签到
     *
     * @param id     签到的id
     * @param openId 用户的id
     * @param jd     用户签到经度
     * @param wd     用户签到纬度
     * @return
     */
    @GetMapping("do")
    public JsonResult SignById(@RequestParam("id") Long id,
                               @RequestParam("openId") String openId,
                               @RequestParam("jd") BigDecimal jd,
                               @RequestParam("wd") BigDecimal wd) {
        if (id == null || openId == null || jd == null || wd == null) {
            // 当参数存在空值的时候
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }

        System.out.println(id +"\t" +openId+"\t"+jd+"\t"+wd);

        // 这里不需要再次判断该用户是否参与该活动，因为前端的签到显示是通过数据库查询显示的，
        // 如果数据库中没有记录，签到的信息不会显示在用户的页面上
        Sign sign = signService.getOne(new QueryWrapper<Sign>().eq("id", id));

        System.out.println(sign.toString());

        User user = userService.getOne(new QueryWrapper<User>().eq("open_id", openId));

        System.out.println(user.toString());

        // 以下代码根据数据库中签到地址经纬度和用户传入的经纬度的距离，最大误差位0.1m ,返回的单位：m
        double distance = DistanceUtil.getDistance(jd.doubleValue(), wd.doubleValue(), sign.getJd().doubleValue(), sign.getWd().doubleValue());
        double scope = sign.getScope().doubleValue();
        System.out.println("====="+distance+"+++");
        // 当距离不在设定的范围内，则用户签到失败！
        if (distance > scope) {
            return JsonResult.error("您当前位置不在既定位置之内，签到失败！");
        }
        if (sign.getBegin().isBefore(LocalDateTime.now()) && sign.getEnd().isAfter(LocalDateTime.now())) {

            int count = signService.isSigned(user.getId(), id);
            if (count == 1) {
                return JsonResult.error("您当前已经签到过了");
            } else {
                // 插入用户签到的记录
                int result = signService.doSign(user.getId(), id, LocalDateTime.now(), jd, wd, 1, LocalDateTime.now(), null, 1);
                return JsonResult.success(result);
            }
        }
        if (sign.getBegin().isAfter(LocalDateTime.now())) {
            return JsonResult.error("签到未开始！");
        }
        if (sign.getEnd().isBefore(LocalDateTime.now())) {
            return JsonResult.error("签到已过期！");
        }
        return JsonResult.error("未知错误！");
    }


    /**
     * 查询用户的所有有效和无效签到
     *
     * @param uid 用户id
     * @return
     */
    @GetMapping("uid/{uid}")
    public JsonResult getUserSign(@PathVariable("uid") Long uid) {
        // 根据用户的id查询所有的签到，当用户参加活动后，结合用户活动表，活动签到表，来查询，该语句可能存在问题
        List<Sign> signList = signService.getAllSignByUserId(uid); // 查询用户所有的签到
        Map<String, Object> map = new HashMap<>();
        List<Sign> vaildSign = new ArrayList<>();
        List<Sign> unvaildSign = new ArrayList<>();
        List<Sign> undoSign = new ArrayList<>();
        signList.stream().forEach(sign -> {

            // 查询用户的某次签到在数据库中是否有记录
            int count = signService.isSigned(uid, sign.getId());

            System.out.println(count);
            // 未过期的签到
            if (sign.getBegin().isAfter(LocalDateTime.now())) {
                // 未过期且没做的签到
                if (count == 0) {
                    undoSign.add(sign);
                }
            } else {
                // 已经签到了的
                if (count == 1) {
                    vaildSign.add(sign);
                }
                // 错过的签到
                else {
                    unvaildSign.add(sign);
                }
            }
        });
        map.put("valid", vaildSign);
        map.put("unvalid", unvaildSign);
        map.put("undo", undoSign);
        return JsonResult.success(map);
    }
}
