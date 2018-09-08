package com.example.dynamic_datasource_method.config.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:54 2018/9/4
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getType();
    }
}
