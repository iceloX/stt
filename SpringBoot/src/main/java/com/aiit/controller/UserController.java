package com.aiit.controller;

import com.aiit.pojo.User;
import com.aiit.service.IUserService;
import com.aiit.utils.returns.CommonEnum;
import com.aiit.utils.returns.JsonResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/5/6
 * @Descriptions
 */
@RestController
@CrossOrigin // 防止跨域请求的问题
@RequestMapping("user")
public class UserController {

    IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    private JsonResult login(
            @RequestParam("code") String code,
            @RequestParam("avatar") String avatar,
            @RequestParam("nickname") String nickname) {
        System.out.println(code + "\n" + nickname + "\n" + avatar);
        if (code.isEmpty()) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        ResponseEntity entity = userService.getOpenId(code);
        String s = entity.getBody().toString();
        System.out.println("===================");
        System.out.println(s);
        System.out.println("====================");

        JSONObject jsonObject = JSONObject.parseObject(s);
        // 获取 openId;
        String openid = jsonObject.getString("openid");
        if (openid.isEmpty()) {
            return JsonResult.error("获取openId失败！");
        }
        User user;
        user = userService.getOne(new QueryWrapper<User>().eq("open_id", openid));
        if (user == null) {
            user = new User();
            user.setOpenId(openid);
            user.setNickname(nickname);
            user.setAvatar(avatar);
            userService.save(user);
        }

        return JsonResult.success(user);
    }


    @GetMapping("community/{id}")
    private JsonResult getUserByComId(@PathVariable("id") Long id) {
        List<User> users;
        if (id == null) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        users = userService.getUserByComId(id);
        return JsonResult.success(users);
    }

    @GetMapping("info")
    private JsonResult getUserByOpenId(@RequestParam("openId") String openId) {
        System.out.println(openId);
        if (openId.isEmpty()) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        User user = userService.getOne(new QueryWrapper<User>().eq("open_id", openId));
        if (user == null) {
            return JsonResult.error("用户不存在！");
        } else {
            return JsonResult.success(user);
        }

    }
}
