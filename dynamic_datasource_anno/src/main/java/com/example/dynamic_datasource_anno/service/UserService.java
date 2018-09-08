package com.example.dynamic_datasource_anno.service;

import com.example.dynamic_datasource_anno.config.mybatis.DataSourceType;
import com.example.dynamic_datasource_anno.config.mybatis.anno.DBType;
import com.example.dynamic_datasource_anno.db.dao.UserMapper;
import com.example.dynamic_datasource_anno.db.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:29 2018/9/3
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @DBType(DataSourceType.SLAVE)
    public void select(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getId() + "--" + user.getName() + "==" + user.getGender());
    }

    @DBType(DataSourceType.MASTER)
    public void insert(User user){
        userMapper.insertSelective(user);
    }
}
