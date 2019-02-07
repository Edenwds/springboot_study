package com.example.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 16:37 2018/12/29
 */
@EnableConfigurationProperties(CacheProperties.class)
@Configuration
public class CacheConfig {

    @Autowired
    private CacheProperties cacheProperties;


    @Bean("cacheLoader")
    public CacheLoadCustom cacheLoadCustom(){
        return new CacheLoadCustom();
    }

    @Bean("cacheCaffeine")
    public Caffeine caffeine(){
        Caffeine caffeine = Caffeine.newBuilder().maximumSize(cacheProperties.getMaximnumSize());
        caffeine.initialCapacity(cacheProperties.getInitialCapacity());
        caffeine.refreshAfterWrite(cacheProperties.getRefreshAfterWrite(), TimeUnit.SECONDS);
        caffeine.expireAfterWrite(cacheProperties.getExpireAfterWrite(), TimeUnit.SECONDS);
        return caffeine;
    }


    @Bean
    public CacheManager cacheManager(@Qualifier("cacheLoader") CacheLoadCustom cacheLoadCustom,
                                     @Qualifier("cacheCaffeine") Caffeine caffeine){
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();

        caffeineCacheManager.setCacheLoader(cacheLoadCustom);
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }
}
