package com.example.dynamic_datasource_anno.config.mybatis.anno;

import com.example.dynamic_datasource_anno.config.mybatis.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:43 2018/9/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DBType {
    DataSourceType value() default DataSourceType.MASTER;
}
