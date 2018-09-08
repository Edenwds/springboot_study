package com.example.dynamic_datasource_method.config.mybatis;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:54 2018/9/4
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<>();

    public static void setType(String methodType){
        dataSourceHolder.set(methodType);
    }

    public static String getType(){
        return dataSourceHolder.get();
    }

    public static void clearType(){
        dataSourceHolder.remove();
    }
}
