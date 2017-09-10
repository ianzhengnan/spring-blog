package com.ian.sblog.chapter7.advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticMethodAdvisorTest {

    @Test
    public void staticMethod(){
        String configPath = "com/ian/sblog/chapter7/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");

        waiter.greedTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }
}
