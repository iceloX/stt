package com.aiit.service.impl;

import com.aiit.dao.ISignMapper;
import com.aiit.pojo.Sign;
import com.aiit.service.ISignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class SignServiceImpl extends ServiceImpl<ISignMapper, Sign> implements ISignService {

    ISignMapper signMapper;

    @Autowired
    public void setSignMapper(ISignMapper signMapper) {
        this.signMapper = signMapper;
    }

    @Override
    public List<Sign> getAllSignByUserId(Long uid) {
        return signMapper.getAllSignByUserId(uid);
    }

    @Override
    public int isSigned(Long uid, Long signId) {
        return signMapper.isSigned(uid, signId);
    }

    @Override
    public int doSign(Long uid, Long signId, LocalDateTime signTime, BigDecimal signJ, BigDecimal signW, Integer status, LocalDateTime createTime, LocalDateTime updateTime, Integer version) {
        return signMapper.doSign(uid, signId, signTime, signJ, signW, status, createTime, updateTime, version);
    }
}
