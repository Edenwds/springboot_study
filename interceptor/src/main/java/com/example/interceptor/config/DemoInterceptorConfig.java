package com.example.interceptor.config;

import com.example.interceptor.interceptor.DemoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: wds
 * @Description: register the interceptor
 * @Date: created in 11:51 2018/10/11
 */
@Component
public class DemoInterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private DemoInterceptor demoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor).addPathPatterns("/hello");
    }
}
