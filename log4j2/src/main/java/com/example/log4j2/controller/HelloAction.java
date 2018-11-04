package com.example.log4j2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 13:53 2018/6/1
 */
@RestController
public class HelloAction {

    private Logger logger = LogManager.getLogger(this.getClass());

    @RequestMapping("hello")
    public void hello(){
        logger.info("logger test");
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestParam  String name){
        return "Hello " + name;
    }
}
