package com.ian.sblog.x4.chapter15;

import com.ian.sblog.x4.chapter15.cachegroup.User;
import com.ian.sblog.x4.chapter15.guava.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GuavaTest {

    @Test
    public void guavaUserTest(){
        String configPath = "com/ian/sblog/x4/chapter15/guava/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        UserService userService = (UserService) ctx.getBean("guavaUserService");

        com.ian.sblog.x4.chapter15.cachegroup.User user = new User("1", null, 37);
        System.out.println("First query.....");
        userService.getUser(user);
        System.out.println("Second query....");
        userService.getUser(user);
    }
}
