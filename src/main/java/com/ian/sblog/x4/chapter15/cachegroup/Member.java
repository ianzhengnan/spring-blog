package com.ian.sblog.x4.chapter15.cachegroup;

public class Member extends User{

    public Member(String id, String userName, Integer age) {
        super(id, userName);
        super.setAge(age);
    }
}
