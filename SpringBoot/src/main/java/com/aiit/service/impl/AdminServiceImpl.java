package com.aiit.service.impl;

import com.aiit.dao.IAdminMapper;
import com.aiit.pojo.Admin;
import com.aiit.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@Service
public class AdminServiceImpl extends ServiceImpl<IAdminMapper, Admin> implements IAdminService {
}
