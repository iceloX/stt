package com.aiit.service.impl;

import com.aiit.dao.ISignMapper;
import com.aiit.pojo.Sign;
import com.aiit.service.ISignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
