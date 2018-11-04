package com.example.interceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 15:48 2018/10/18
 */
@RestController
public class DemoController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/hi")
    public String hi(){
        return "hi world";
    }
}
