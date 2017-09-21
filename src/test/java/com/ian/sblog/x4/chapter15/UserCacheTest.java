package com.ian.sblog.x4.chapter15;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserCacheTest {

    @Test
    public void userCache(){

        String configPath = "com/ian/sblog/x4/chapter15/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User("0001");
//        user.setAge(23); // condition = #user.age > 35 所以它不符合缓存条件
        user.setAge(36);
        user.setUserName("kakala"); // condition = #user.age > 35 && #user.username.length() > 5

        System.out.println("first query....");
        userService.getUserById(user);
        System.out.println("second query....");
        userService.getUserById(user);



    }
}
