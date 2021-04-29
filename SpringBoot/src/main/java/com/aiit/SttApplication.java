package com.aiit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // 使用Swagger
@MapperScan("com.aiit.dao") // 扫描所在的mapper
public class SttApplication {

    public static void main(String[] args) {
        SpringApplication.run(SttApplication.class, args);
    }

}
