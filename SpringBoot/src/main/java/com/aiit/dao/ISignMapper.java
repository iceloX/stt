package com.aiit.dao;

import com.aiit.pojo.Sign;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
     *
     * @param uid 用户的id
     * @return
     */
    List<Sign> getAllSignByUserId(@Param("uid") Long uid);

    /**
     * 判断用户是不是完成了某一次的签到了
     *
     * @param uid
     * @param signId
     * @return
     */
    int isSigned(@Param("uid") Long uid, @Param("signId") Long signId);

    int doSign(@Param("uid") Long uid, @Param("signId") Long signId, @Param("signTime") LocalDateTime signTime,
               @Param("signJ") BigDecimal signJ, @Param("signW") BigDecimal signW, @Param("status") Integer status,
               @Param("createTime") LocalDateTime createTime, @Param("updateTime") LocalDateTime updateTime,
               @Param("version") Integer version);
}
