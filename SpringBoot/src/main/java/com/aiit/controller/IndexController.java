package com.aiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author icelo
 * @Date 2021/4/27
 * @Descriptions
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String getIndex(){
        return "test";
    }
}
