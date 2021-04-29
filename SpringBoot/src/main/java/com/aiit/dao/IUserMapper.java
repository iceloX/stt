package com.aiit.dao;

import com.aiit.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Repository;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Repository
public interface IUserMapper extends BaseMapper<User> {
}
