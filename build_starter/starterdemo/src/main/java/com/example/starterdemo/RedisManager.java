package com.example.starterdemo;

import com.wds.redis.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 13:09 2018/9/23
 */
@Component
public class RedisManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisManager.class);

    @Autowired
    private RedisConfig redisConfig;

    @PostConstruct
    private void init(){
       logger.info("RedisManager successfully initialized");
    }
}
