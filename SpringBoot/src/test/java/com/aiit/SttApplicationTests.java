package com.aiit;

import com.aiit.service.ICommunityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SttApplicationTests {

    @Autowired
    ICommunityService communityService;

    @Test
    void contextLoads() {
        // 查询所有的社团
        communityService.list().forEach(System.out::println);

    }

}
