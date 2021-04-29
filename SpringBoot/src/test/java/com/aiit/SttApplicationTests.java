package com.aiit;

import com.aiit.pojo.Activity;
import com.aiit.pojo.Community;
import com.aiit.service.IActivityService;
import com.aiit.service.ICommunityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@SpringBootTest
class SttApplicationTests {

    @Autowired
    ICommunityService communityService;

    @Autowired
    IActivityService activityService;

    @Test
    void contextLoads() {
        activityService.list().forEach(System.out::println);
    }

}
