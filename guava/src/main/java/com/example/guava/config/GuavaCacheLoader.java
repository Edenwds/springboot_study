package com.example.guava.config;

import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuavaCacheLoader extends CacheLoader<String,String> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Override
    public String load(String s) throws Exception {
        if (s.equals("hello")) {
            Thread.sleep(3000);
            return "world";
        } else if (s.equals("world")) {
            Thread.sleep(5000);
            return "hello";
        }
        return "no value";
    }

    @Override
    public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
        ListenableFutureTask<String> task = ListenableFutureTask.create(new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (key.equals("hello")) {
                    return "nihao";
                } else if (key.equals("world")) {
                    return "shijie";
                }
                return "no value";
            }
        });

        executorService.submit(task);
        return task;
    }
}
