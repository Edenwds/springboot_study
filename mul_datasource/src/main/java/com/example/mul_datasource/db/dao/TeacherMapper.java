package com.example.mul_datasource.db.dao;

import com.example.mul_datasource.config.mybatis.datasource.anno.UseDatasourceFirst;
import com.example.mul_datasource.db.pojo.Teacher;

@UseDatasourceFirst
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}