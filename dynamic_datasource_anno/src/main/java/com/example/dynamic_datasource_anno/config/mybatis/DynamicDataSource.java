package com.example.dynamic_datasource_anno.config.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:02 2018/9/2
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getType();
    }
}
