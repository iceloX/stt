package com.aiit.service.impl;

import com.aiit.dao.ICommunityMapper;
import com.aiit.dao.IUserMapper;
import com.aiit.pojo.Community;
import com.aiit.service.ICommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<ICommunityMapper, Community> implements ICommunityService {


    ICommunityMapper communityMapper;

    @Autowired
    public void setCommunityMapper(ICommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }



    @Override
    public int isPartedCommunity(Long id, Long cid) {
        return communityMapper.isPartedCommunity(id, cid);
    }
}
