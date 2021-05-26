package com.aiit;

import com.aiit.pojo.Activity;
import com.aiit.pojo.Article;
import com.aiit.pojo.Community;
import com.aiit.pojo.Sign;
import com.aiit.service.IActivityService;
import com.aiit.service.IArticleService;
import com.aiit.service.ICommunityService;
import com.aiit.service.ISignService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@SpringBootTest
class SttApplicationTests {

    @Autowired
    ICommunityService communityService;

    @Autowired
    IActivityService activityService;

    @Autowired
    ISignService signService;

    @Autowired
    IArticleService articleService;

    @Test
    void contextLoads() throws IOException, URISyntaxException {


        Article article = new Article();

        article.setAuthor("冰洛");
        article.setContent("https://mp.weixin.qq.com/s?__biz=MzI2ODUxMzg4Nw==&mid=2247485016&idx=1&sn=e5f60600ea30f669264ddcf5db4fb080&chksm=eaef2168dd98a87ead60eed0f24e799c1befbfe95e341231216af72315c33a56839f92e69ef9&token=29762947&lang=zh_CN#rd");
        article.setCategory("微信公众号");
        article.setCover("https://image.icelo.cn/p1.jpg");
        article.setStatus(1);
        article.setName("CSS垂直居中技巧，我只会23个，你会几个？");
        article.setCreateTime(LocalDateTime.now());
        article.setDescription("CSS垂直居中技巧，我只会23个，你会几个？");
        article.setViews(0);
        boolean save = articleService.save(article);
        System.out.println(save);
    }

}
