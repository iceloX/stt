package com.aiit.dao;

import com.aiit.pojo.Sign;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Repository
public interface ISignMapper extends BaseMapper<Sign> {

    /**
     * 根据用户的id查询所有的签到
     * @param uid 用户的id
     * @return
     */
    List<Sign> getAllSignByUserId(@Param("uid")Long uid);
}
