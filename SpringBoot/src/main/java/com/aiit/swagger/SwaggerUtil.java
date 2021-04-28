package com.aiit.swagger;

/**
 * @Author icelo
 * @Date 2021/4/27
 * @Descriptions
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerUtil {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aiit.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("信工社团通")
                        .description("基于SpringBoot+Vue的一体化管理平台")
                        .version("1.0")
                        .contact(new Contact("icelo", "https:www.icelo.cn", "i@icelo.com")
                        )
                        .license("The Apache License")
                        .licenseUrl("https:www.baidu.com")
                        .build());
    }
}

