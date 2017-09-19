package com.ian.sblog.x4.chapter8;

import com.ian.sblog.x4.chapter8.aspectj.*;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectProxyTest {

    @Test
    public void aspectjTest(){
        Gongfu gongfu = new NormalGongfu();
        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(gongfu); // 设置目标对象
        factory.addAspect(PreBoxingAspect.class); // 添加切面类
        Gongfu daxia = factory.getProxy(); // 生成织入切面的代理对象

        daxia.boxTo("张三");
        daxia.kickTo("李四");
    }

    @Test
    public void aspectjTestWithConfig(){

        String configPath = "com/ian/sblog/x4/chapter8/aspectj/beans.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Gongfu daxia = (Gongfu) ctx.getBean("gongfu");

        daxia.kickTo("张三");
        // 控制台会显示如下信息：
        // Returning cached instance of singleton bean 'com.ian.sblog.x4.chapter8.aspectj.PreBoxingAspect#0'
        // 这个是生成的被增强了的代理类
        daxia.boxTo("李四"); //这个方法被增强了
    }

    @Test
    public void introduceAspectjTest(){

        String configPath = "com/ian/sblog/x4/chapter8/aspectj/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Gongfu daxia = (Gongfu) ctx.getBean("gongfu");
        daxia.boxTo("李四");
        LiaoShang doctor = (LiaoShang)daxia;
        doctor.addBlood("张三", "李四");
    }

}
