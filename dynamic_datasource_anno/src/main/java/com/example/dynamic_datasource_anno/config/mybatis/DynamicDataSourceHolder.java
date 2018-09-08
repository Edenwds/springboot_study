package com.example.dynamic_datasource_anno.config.mybatis;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:03 2018/9/2
 */
public class DynamicDataSourceHolder {
    private static final ThreadLocal<DataSourceType> dataSourceHolder = new ThreadLocal<>();

    private static final Set<DataSourceType> dataSourceTypes = new HashSet<>();
    static {
        dataSourceTypes.add(DataSourceType.MASTER);
        dataSourceTypes.add(DataSourceType.SLAVE);
    }

    public static void setType(DataSourceType dataSourceType){
        if(dataSourceType == null){
            throw new NullPointerException();
        }
        dataSourceHolder.set(dataSourceType);
    }

    public static DataSourceType getType(){
        return dataSourceHolder.get();
    }

    public static void clearType(){
        dataSourceHolder.remove();
    }

    public static boolean containsType(DataSourceType dataSourceType){
        return dataSourceTypes.contains(dataSourceType);
    }
}
