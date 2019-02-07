package com.example.mongodb.interfaces;

import com.example.mongodb.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 9:57 2018/5/25
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUname(String uname);

    User findUserByAge(Integer age);

    User findUserByUidAndAge(String uid, Integer age);

    List<User> findUsersByAgeIn(Integer... ages);

    //(start, end) 不包含起始位置的值
    List<User> findUsersByUidBetweenOrderByAgeDesc(String startId, String endId);

    List<User> findUsersByUnameIn(String... unames);

    List<User> findUsersByUidContaining(String uids);

    Page<User> findUsersByUidIn(Pageable pageable, String... uids);
}