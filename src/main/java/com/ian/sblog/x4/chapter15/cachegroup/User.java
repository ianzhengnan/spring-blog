package com.ian.sblog.x4.chapter15.cachegroup;

import java.io.Serializable;

public class User implements Serializable{

    private String id;
    private String userName;
    private Integer age;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User(String id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User { id: " + getId() + ", name: " + getUserName() + ", age: " + getAge() + " }";
    }
}
