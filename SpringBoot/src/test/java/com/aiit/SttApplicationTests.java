package com.aiit;

import com.aiit.pojo.Community;
import com.aiit.service.IActivityService;
import com.aiit.service.ICommunityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SttApplicationTests {

    @Autowired
    ICommunityService communityService;

    @Autowired
    IActivityService activityService;

    @Test
    void contextLoads() {
        // 查询所有的社团
         communityService.list().forEach(System.out::println);


    }

}
