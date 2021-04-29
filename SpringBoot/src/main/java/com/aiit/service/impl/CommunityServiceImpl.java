package com.aiit.service.impl;

import com.aiit.dao.ICommunityMapper;
import com.aiit.pojo.Community;
import com.aiit.service.ICommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<ICommunityMapper, Community> implements ICommunityService {
}
