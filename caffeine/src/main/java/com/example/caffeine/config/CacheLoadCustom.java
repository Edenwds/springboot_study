package com.example.caffeine.config;

import com.github.benmanes.caffeine.cache.CacheLoader;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 17:05 2018/12/29
 */
public class CacheLoadCustom implements CacheLoader{

    @Override
    public Object load(Object o) throws Exception {
        if (o.toString().equalsIgnoreCase("hello")) {
            Thread.sleep(3000);
            return o.toString();
        } else if (o.toString().equalsIgnoreCase("world")) {
            Thread.sleep(5000);
            return o.toString();
        }
        return o.toString();
    }

    @Override
    public Object reload(Object key, Object oldValue) throws Exception {
        if (key.toString().equalsIgnoreCase("hello")) {
            return "world";
        } else if (key.toString().equalsIgnoreCase("world")) {
            return "hello";
        }
        return "no value";
    }
}
