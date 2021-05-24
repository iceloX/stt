package com.aiit.dao;

import com.aiit.pojo.Community;
import com.aiit.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Repository
public interface IUserMapper extends BaseMapper<User> {
   User getUserByActId(@Param("actId") Long actId,@Param("userId") Long userId);

   List<User> getUserByComId(@Param("cid") Long cid);

   List<Community> getUserAllCommunity(@Param("userId") Long userId);

}
