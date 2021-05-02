package com.aiit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
