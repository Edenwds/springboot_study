package com.example.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 16:23 2018/10/18
 */
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/hi")
    public String hi(){
        return "hi world";
    }
}
