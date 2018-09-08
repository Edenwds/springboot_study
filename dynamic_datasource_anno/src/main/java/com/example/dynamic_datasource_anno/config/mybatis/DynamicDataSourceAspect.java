package com.example.dynamic_datasource_anno.config.mybatis;

import com.example.dynamic_datasource_anno.config.mybatis.anno.DBType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:43 2018/9/2
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(dbType)")
    public void changeDataSourceType(JoinPoint joinPoint, DBType dbType){
        DataSourceType curType = dbType.value();
        if(!DynamicDataSourceHolder.containsType(curType)){
            logger.info("指定数据源[{}]不存在，使用默认数据源-> {}",dbType.value(),joinPoint.getSignature());
        }else{
            logger.info("use datasource {} -> {}",dbType.value(),joinPoint.getSignature());
            DynamicDataSourceHolder.setType(dbType.value());
        }

    }

    @After("@annotation(dbType)")
    public void restoreDataSource(JoinPoint joinPoint, DBType dbType){
        logger.info("use datasource {} -> {}",dbType.value(),joinPoint.getSignature());
        DynamicDataSourceHolder.clearType();
    }

}
