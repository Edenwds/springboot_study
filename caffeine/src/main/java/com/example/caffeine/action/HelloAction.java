package com.example.caffeine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 16:38 2019/1/2
 */
@RestController
public class  HelloAction {

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/hello")
    public String hello(){
        long start = System.currentTimeMillis();
        String res = cacheManager.getCache("hello").get("hello").get().toString();
        long end = System.currentTimeMillis();
        return res + " wait time " + (end - start);
    }

    @RequestMapping("/world")
    public String world(){
        long start = System.currentTimeMillis();
        String res = cacheManager.getCache("world").get("world").get().toString();
        long end = System.currentTimeMillis();
        return res + " wait time " + (end - start);
    }


}
