package com.wds.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 12:35 2018/9/23
 */
public class RedisConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    private RedisProperties redisProperties;

    public RedisConfig(){}

    public RedisConfig(RedisProperties redisProperties){
        this.redisProperties = redisProperties;
    }

    @PostConstruct
    private void init(){
        logger.info(String.format("Init Config -- host : %s, port : %d, timeout : %d %n",redisProperties.getHost(),redisProperties.getPort(),redisProperties.getTimeout()));
    }
}
