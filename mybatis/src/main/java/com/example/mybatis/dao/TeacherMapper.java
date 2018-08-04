package com.example.mybatis.dao;

import com.example.mybatis.bean.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(String tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}