package com.ian.sblog.x4.chapter8;

import com.ian.sblog.service.impl.ForumServiceImpl;
import com.ian.sblog.x4.chapter8.annotation.NeedTest;
import org.junit.Test;

import java.lang.reflect.Method;

public class ToolTest {

    @Test
    public void tool(){
        Class clazz = ForumServiceImpl.class;

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("共有" + methods.length + "个Method.");
        for (Method method : methods) {
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null){
                if (nt.value()){
                    System.out.println(method.getName() + "()需要测试");
                }else{
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }

    }
}
