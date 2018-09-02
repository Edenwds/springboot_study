package com.example.mul_datasource.db2.dao;

import com.example.mul_datasource.config.mybatis.datasource.anno.UseDatasourceSecond;
import com.example.mul_datasource.db2.pojo.Student;

@UseDatasourceSecond
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}