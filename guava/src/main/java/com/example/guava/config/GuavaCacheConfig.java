package com.example.guava.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 14:58 2018/10/8
 */

@EnableConfigurationProperties(GuavaProperties.class)
@Configuration
@EnableCaching
public class GuavaCacheConfig {

    @Autowired
    private GuavaProperties guavaProperties;

    @Bean
    public CacheBuilder<Object,Object> cacheBuilder(){
        long maximumSize = guavaProperties.getMaximumSize();
        long expireAfterWrite = guavaProperties.getExpireAfterWriteDuration();
        long expireAfterAccess = guavaProperties.getExpireAfterAccessDuration();
        long refreshDuration = guavaProperties.getRefreshDuration();

        if(maximumSize <= 0){
            maximumSize = 1024;
        }
        if(expireAfterAccess <= 0){
            expireAfterAccess = 3600;
        }
        if(expireAfterWrite <= 0){
            expireAfterWrite = 3600;
        }

        if(refreshDuration <= 0){
            refreshDuration = 1800;
        }
        return CacheBuilder.newBuilder().maximumSize(maximumSize)
                .expireAfterWrite(expireAfterWrite,TimeUnit.SECONDS)
                .refreshAfterWrite(refreshDuration,TimeUnit.SECONDS);
    }

    @Bean(name = "guavaCacheLoader")
    public CacheLoader cacheLoader(){
        return new GuavaCacheLoader();
    }

    @Bean
    public CacheManager cacheManager(@Qualifier("cacheBuilder")CacheBuilder cacheBuilder,
                                    @Qualifier("guavaCacheLoader")CacheLoader cacheLoader){
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(cacheBuilder);
        cacheManager.setCacheLoader(cacheLoader);
        return cacheManager;
    }

}
