package com.ian.sblog.chapter7;

import org.junit.Test;

public class TestRandom {

    @Test
    public void testRandom(){
        int number = (int)((Math.random() * 9 + 1) * 100000);
        System.out.println(String.valueOf(number));
    }
}
