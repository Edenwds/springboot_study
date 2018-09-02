package com.example.mul_datasource.config.mybatis.datasource;

import com.example.mul_datasource.config.mybatis.datasource.anno.UseDatasourceSecond;
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
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 13:21 2018/9/2
 */
@Configuration
@MapperScan(basePackages = "com.example.mul_datasource.db2.dao", annotationClass = UseDatasourceSecond.class, sqlSessionFactoryRef = SecondDatasourceConfig.SQL_SESSION_FACTORY_NAME)
public class SecondDatasourceConfig {
    public static final String SQL_SESSION_FACTORY_NAME = "sqlSessionFactorySecond";
    public static final String TRANSACTION_MANAGER = "txManageSecond";
    protected Logger logger = LoggerFactory.getLogger(SecondDatasourceConfig.class);

    @Bean(name = "datasourceSecond")
    @ConfigurationProperties(prefix = "datasource.second")
    public DataSource dataSourceSecond(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = SecondDatasourceConfig.TRANSACTION_MANAGER)
    public PlatformTransactionManager txManagerSecond(@Qualifier("datasourceSecond") DataSource datasourceSecond){
        return new DataSourceTransactionManager(datasourceSecond);
    }

    @Bean(name = SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "datasourceSecond") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("com.example.mul_datasource.db2.pojo");
        Resource[] resources = new PathMatchingResourcePatternResolver()
                               .getResources("classpath:com/example/mul_datasource/db2/mapper/*Mapper.xml");
        sessionFactoryBean.setMapperLocations(resources);
        return sessionFactoryBean.getObject();
    }
}
