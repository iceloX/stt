package com.aiit.controller;

import com.aiit.config.quartz.DynamicTaskConfig;
import com.aiit.pojo.Sign;
import com.aiit.service.ICommunityService;
import com.aiit.service.ISignService;
import com.aiit.utils.date.DateUtil;
import com.aiit.utils.qrcode.QRCodeUtil;
import com.aiit.utils.quartz.CronDateUtils;
import com.aiit.utils.returns.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/all")
    public JsonResult getAllSign() {
        List<Sign> signs = signService.list();
        for (Sign sign : signs) {
            if (LocalDateTime.now().isBefore(sign.getBegin()))  // 遍历所有签到，在开始之前的签到都开启一个新线程
                new Thread(() -> {
                    String taskName = sign.getName();
                    //判断数据库中是否已经保存了定时时间的配置，有就从数据库中取出赋值给cron,没有就将默认cron的值存入数据库
                    LocalDateTime begin = sign.getBegin();
                    System.out.println(begin);
                    Date date = DateUtil.loca2Date(begin);
                    System.out.println(date.toString());
                    String cron = CronDateUtils.getCron(date);
                    cron = cron.substring(0,cron.length()-4);
                    System.out.println(cron);
                    dynamicTaskConfig.startCron(taskName,()->{
                        try {
                            QRCodeUtil.encode("https://icelo.cn",new FileOutputStream("D:\\test.jpg"));
                            Runtime rt = Runtime.getRuntime();
                            rt.exec(new String[]{"cmd", "/c","start chrome D:\\test.jpg"});
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    },cron);
                }).start();
        }
        return JsonResult.success(signs);
    }

}
