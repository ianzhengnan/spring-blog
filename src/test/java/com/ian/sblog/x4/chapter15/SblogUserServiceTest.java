package com.ian.sblog.x4.chapter15;

import com.ian.sblog.dao.UserDao;
import com.ian.sblog.service.impl.UserServiceImpl;
import org.junit.Test;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

@SpringApplicationContext("classpath:applicationContext.xml")
public class SblogUserServiceTest {

    @SpringBean("userDao")
    private UserDao userDao;

    @Test
    public void sblogUserServiceCacheTest(){

        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        System.out.println("first query....");
        userService.logon("jan", "jan1234");
        System.out.println("second query....");
        userService.logon("jan", "jan1234");
    }
}
