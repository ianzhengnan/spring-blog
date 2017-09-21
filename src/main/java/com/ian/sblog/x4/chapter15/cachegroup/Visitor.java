package com.ian.sblog.x4.chapter15.cachegroup;

public class Visitor extends User {

    public Visitor(String id, String userName, Integer age) {
        super(id, userName);
        super.setAge(age);
    }
}
