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
//       Activity activity = new Activity();
//       activity.setName("互联网大学生创新创业大赛");
//       activity.setDescription("大赛旨在深化高等教育综合改革，激发大学生的创造力，培养造就“大众创业、万众创新”的主力军；推动赛事成果转化，促进“互联网+”新业态形成，服务经济提质增效升级；");
//       activity.setCover("http://stt.yylit.com/activity_1.png");
//       activity.setVersion(1);
//       activity.setScore(100f);
//       activity.setStatus(1);
//       activity.setPlace("东二503");
//       activity.setBegin(new Date());
//       activity.setEnd(new Date());
//
//        System.out.println(activityService.save(activity));


        Community community =new Community();
        community.setName("讯飞职业俱乐部");
        community.setStatus(0);
        community.setScore(60f);
        community.setVersion(1);
        community.setDescription("讯飞职业俱乐部");
        community.setLogo("http://stt.yylit.com/activity_1.png");
        community.setHead("河北");
        System.out.println(communityService.save(community));

    }

}
