package com.aiit.service;

import com.aiit.pojo.Activity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
public interface IActivityService extends IService<Activity> {
    Activity getActBySignId(@Param("signId") Long signId);
}
