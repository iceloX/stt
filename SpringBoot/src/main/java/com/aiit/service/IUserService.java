package com.aiit.service;

import com.aiit.pojo.Community;
import com.aiit.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
public interface IUserService extends IService<User> {



    ResponseEntity getOpenId(String code);

    User getUserByActId(@Param("actId") Long actId,@Param("userId") Long userId);

    List<User> getUserByComId(@Param("cid") Long cid);

    List<Community> getUserAllCommunity(@Param("userId") Long userId);
}
