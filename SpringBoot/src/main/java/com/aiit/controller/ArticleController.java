package com.aiit.controller;

import com.aiit.pojo.Article;
import com.aiit.service.IArticleService;
import com.aiit.utils.returns.JsonResult;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2SmileDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/5/26
 * @Descriptions
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    IArticleService articleService;

    @Autowired
    public void setArticleService(IArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("all")
    public JsonResult getAllArticle(){
        List<Article> articles = articleService.list();
        return JsonResult.success(articles);
    }
}
