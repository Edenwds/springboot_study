package com.example.guava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("hello")
    public String hello(){
        long start = System.currentTimeMillis();
        String value = cacheManager.getCache("hello").get("hello").get().toString();
        long end = System.currentTimeMillis();

        return String.format("value=[%s], wait time : [%d]",value,(end - start));
    }

    @RequestMapping("world")
    public String world(){
        long start = System.currentTimeMillis();
        String value = cacheManager.getCache("world").get("world").get().toString();
        long end = System.currentTimeMillis();

        return String.format("value=[%s], wait time : [%d]",value,(end - start));
    }
}
