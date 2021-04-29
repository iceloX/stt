package com.aiit.service.impl;

import com.aiit.dao.ISignMapper;
import com.aiit.pojo.Sign;
import com.aiit.service.ISignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class SignServiceImpl extends ServiceImpl<ISignMapper, Sign> implements ISignService {
}
