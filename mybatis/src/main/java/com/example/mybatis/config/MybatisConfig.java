package com.example.mybatis.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 16:17 2018/8/4
 */
@Configuration
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.example.mybatis.bean");
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath*:com/example/mybatis/mapper/*Mapper.xml");
        sessionFactory.setMapperLocations(resources);

        return sessionFactory;
    }
}
