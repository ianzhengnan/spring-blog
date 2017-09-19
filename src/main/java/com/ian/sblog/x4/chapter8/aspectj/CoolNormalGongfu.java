package com.ian.sblog.x4.chapter8.aspectj;

import com.ian.sblog.x4.chapter8.annotation.NeedTest;

public class CoolNormalGongfu implements Gongfu{

    public void wuyingjiao(String badGuy){
        System.out.println("用无影脚踢" + badGuy);
    }

    @Override
    public void boxTo(String badGuy) {
        System.out.println("酷拳打" + badGuy);
    }

    @Override
    @NeedTest
    public void kickTo(String badGuy) {
        System.out.println("酷腿踢" + badGuy);
    }
}
