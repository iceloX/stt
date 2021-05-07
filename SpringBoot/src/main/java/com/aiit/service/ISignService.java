package com.aiit.service;

import com.aiit.pojo.Sign;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
public interface ISignService extends IService<Sign> {
    List<Sign> getAllSignByUserId(@Param("uid")Long uid);
}
