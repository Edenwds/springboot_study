package com.example.mongodb.domain;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 9:56 2018/5/25
 */
public class User {

    private String uid;
    private String uname;
    private Integer age;

    public User() {
    }

    public User(String uid, String uname, int age) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public User(String uid, String uname, Integer age) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }
}
