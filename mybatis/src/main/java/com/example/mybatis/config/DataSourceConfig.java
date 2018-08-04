package com.example.mybatis.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 16:25 2018/8/4
 */
@Configuration
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "c3p0.datasource")
    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
}
