package com.aiit.service.impl;

import com.aiit.dao.IUserMapper;
import com.aiit.pojo.User;
import com.aiit.service.IUserService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {


    private static String appid = "wxb3906b75648e1658";
    private static String secret = "efdcfcaf93df81a915d00d9503c505b6";

    RestTemplate restTemplate;

    IUserMapper userMapper;

    @Autowired
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        return restTemplate.getForEntity(url, String.class);
    }

    @Override
    public User getUserByActId(Long actId,Long userId) {
        return userMapper.getUserByActId(actId,userId);
    }
}
