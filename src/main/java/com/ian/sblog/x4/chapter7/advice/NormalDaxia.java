package com.ian.sblog.x4.chapter7.advice;

public class NormalDaxia implements Daxia {
    @Override
    public void kickTo(String badguy) {
        System.out.println("Kick to " + badguy + "....");
    }

    @Override
    public void boxTo(String badguy) {
        System.out.println("Box to " + badguy + "....");
    }
}
