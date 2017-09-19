package com.ian.sblog.x4.chapter8.aspectj;

public class NormalGongfu implements Gongfu{

    public void boxTo(String badGuy){
        System.out.println("拳打" + badGuy);
    }

    public void kickTo(String badGuy){
        System.out.println("脚踢" + badGuy);
    }

    public void headTo(String badGuy){
        System.out.println("头顶" + badGuy);
    }
}
