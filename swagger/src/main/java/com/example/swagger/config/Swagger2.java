package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:10 2018/8/3
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller")) //扫描该包下所有的controller
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger RESTful APIs ")  //API文档标题
                .description("学习swagger构建restful api") // 文档描述
                .termsOfServiceUrl("https://blog.csdn.net/sinat_36553913")
                .version("1.0")
                .build();
    }
}

