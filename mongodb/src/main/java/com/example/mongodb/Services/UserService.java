package com.example.mongodb.Services;


import com.example.mongodb.domain.User;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 17:11 2019/2/4
 */
public class UserService {

    public static void main(String[] args) {
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "test");
        mongoOps.insert(new User("1005", "zhaoliu", 23), "collectionName");
        User user = mongoOps.findOne(new Query(where("uid").is("1004")), User.class);
        System.out.println(user.getUname());
    }

}
