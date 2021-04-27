package com.aiit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // 使用Swagger
public class SttApplication {

    public static void main(String[] args) {
        SpringApplication.run(SttApplication.class, args);
    }

}
