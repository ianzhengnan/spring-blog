package com.ian.sblog.x4.chapter8.aspectj;

public class NormalGongfu implements Gongfu{

    public void boxTo(String badGuy){
        System.out.println("Box to " + badGuy);
    }

    public void kickTo(String badGuy){
        System.out.println("Kick to " + badGuy);
    }
}
