package com.aiit.dao;

import com.aiit.pojo.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Repository
public interface IActivityMapper extends BaseMapper<Activity> {

     Activity getActBySignId(@Param("signId") Long signId);
}
