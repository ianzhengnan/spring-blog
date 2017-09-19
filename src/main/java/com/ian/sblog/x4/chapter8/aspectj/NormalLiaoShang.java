package com.ian.sblog.x4.chapter8.aspectj;

public class NormalLiaoShang implements LiaoShang {
    @Override
    public void addBlood(String doctor, String goodGuy) {
        System.out.println(doctor + "给" + goodGuy + "加了个血！");
    }
}
