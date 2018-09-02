package com.example.mul_datasource.config.mybatis.datasource;

import com.example.mul_datasource.config.mybatis.datasource.anno.UseDatasourceFirst;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 12:22 2018/9/2
 */
@Configuration
@MapperScan(basePackages = "com.example.mul_datasource.db.dao", annotationClass = UseDatasourceFirst.class, sqlSessionFactoryRef = FirstDatasoruceConfig.SQL_SESSION_FACTOR_NAME)
public class FirstDatasoruceConfig {
    public static final String SQL_SESSION_FACTOR_NAME = "sqlSessionFactoryFirst";
    public static final String TRANSACTION_MANAGER="txManagerFirst";
    protected Logger logger = LoggerFactory.getLogger(FirstDatasoruceConfig.class);

    @Bean(name = "datasourceFirst")
    @Primary
    @ConfigurationProperties(prefix = "datasource.first")
    public DataSource dataSourceFirst(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = TRANSACTION_MANAGER)
    @Primary
    public PlatformTransactionManager txManagerFirst(@Qualifier("datasourceFirst") DataSource datasourceFirst){
        return new DataSourceTransactionManager(datasourceFirst);
    }

    @Bean(name = FirstDatasoruceConfig.SQL_SESSION_FACTOR_NAME)
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasourceFirst") DataSource datasourceFirst) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(datasourceFirst);
        sessionFactoryBean.setTypeAliasesPackage("com.example.mul_datasource.db.pojo");
        Resource[] resources = new PathMatchingResourcePatternResolver()
                               .getResources("classpath:com/example/mul_datasource/db/mapper/*Mapper.xml");
        sessionFactoryBean.setMapperLocations(resources);
        return sessionFactoryBean.getObject();
    }
}
