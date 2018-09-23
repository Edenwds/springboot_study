package com.wds.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 12:47 2018/9/23
 */
@Configuration
@ConditionalOnClass(RedisConfig.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfigure {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    @ConditionalOnMissingBean
    public RedisConfig redisConfig(){
        return new RedisConfig(redisProperties);
    }

}
