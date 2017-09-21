package com.ian.sblog.x4.chapter15;

import com.ian.sblog.x4.chapter15.cachegroup.UserService;
import com.ian.sblog.x4.chapter15.cachegroup.Visitor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserCacheGroupTest {

    @Test
    public void cacheGroupTest(){
        String configName = "com/ian/sblog/x4/chapter15/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configName);

        UserService userService = (UserService) ctx.getBean("cacheGroupUserService");

        Visitor visitor = new Visitor("2", "visitor", 37);

        System.out.println("first query....");
        userService.getUser(visitor);

        System.out.println("second query....");
        userService.getUser(visitor);

    }
}
