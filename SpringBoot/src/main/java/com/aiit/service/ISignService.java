package com.aiit.service;

import com.aiit.pojo.Sign;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
public interface ISignService extends IService<Sign> {
    List<Sign> getAllSignByUserId(@Param("uid") Long uid);

    /**
     * 根据用户ide和signId判断是不是已经签到过来
     *
     * @param uid    用户id
     * @param signId 签到id
     * @return
     */
    int isSigned(@Param("uid") Long uid, @Param("signId") Long signId);


    int doSign(@Param("uid") Long uid, @Param("signId") Long signId, @Param("signTime") LocalDateTime signTime,
               @Param("signJ") BigDecimal signJ, @Param("signW") BigDecimal signW, @Param("status") Integer status,
               @Param("createTime") LocalDateTime createTime, @Param("updateTime") LocalDateTime updateTime,
               @Param("versio") Integer version);


}
