package com.aiit.service.impl;

import com.aiit.dao.IUserMapper;
import com.aiit.pojo.Community;
import com.aiit.pojo.User;
import com.aiit.service.IUserService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {


    private static String appid = "wx77e608257a15f1b7";
    private static String secret = "af0ca6af0c53211e839801efdff55d1e";

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

    @Override
    public List<User> getUserByComId(Long cid) {
        return userMapper.getUserByComId(cid);
    }

    @Override
    public List<Community> getUserAllCommunity(Long userId) {
        return userMapper.getUserAllCommunity(userId);
    }
}
