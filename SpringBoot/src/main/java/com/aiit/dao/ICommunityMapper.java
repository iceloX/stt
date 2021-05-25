package com.aiit.dao;

import com.aiit.pojo.Community;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Repository
public interface ICommunityMapper extends BaseMapper<Community> {
    int isPartedCommunity(@Param("userId")Long userId, @Param("cid") Long cid);
}
