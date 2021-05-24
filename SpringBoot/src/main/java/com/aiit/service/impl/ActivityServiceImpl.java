package com.aiit.service.impl;

import com.aiit.dao.IActivityMapper;
import com.aiit.pojo.Activity;
import com.aiit.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<IActivityMapper, Activity> implements IActivityService {

    IActivityMapper activityMapper;

    @Autowired
    public void setActivityMapper(IActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public Activity getActBySignId(Long signId) {
        return activityMapper.getActBySignId(signId);
    }

    @Override
    public int isPartedActivity(Long userId, Long aid) {
        return activityMapper.isPartedActivity(userId, aid);
    }
}
