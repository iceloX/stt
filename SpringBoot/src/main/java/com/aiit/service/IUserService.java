package com.aiit.service;

import com.aiit.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
public interface IUserService extends IService<User> {
    ResponseEntity getOpenId(String code);
}
