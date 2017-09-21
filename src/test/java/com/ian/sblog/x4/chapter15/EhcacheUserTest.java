package com.ian.sblog.x4.chapter15;

import com.ian.sblog.x4.chapter15.cachegroup.User;
import com.ian.sblog.x4.chapter15.ehcache.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EhcacheUserTest {

    @Test
    public void ehcacheTest(){
        String configPath = "com/ian/sblog/x4/chapter15/ehcache/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        UserService userService = (UserService) ctx.getBean("ehcacheUserService");

        User user = new User("1", null, 37);
        System.out.println("First query.....");
        userService.getUser(user);
        System.out.println("Second query....");
        userService.getUser(user);
    }

}
