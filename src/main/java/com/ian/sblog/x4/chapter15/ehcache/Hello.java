package com.ian.sblog.x4.chapter15.ehcache;

public class Hello {
    private static Hello ourInstance = new Hello();

    public static Hello getInstance() {
        return ourInstance;
    }

    private Hello() {
    }
}
