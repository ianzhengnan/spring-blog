package com.ian.sblog.x4.chapter15;

import com.ian.sblog.domain.User;
import com.ian.sblog.service.UserService;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

@SpringApplicationContext("classpath:applicationContext.xml")
public class SblogUserServiceTest extends UnitilsTestNG {

    @SpringBean("sblogUserService")
    private UserService userService;

    @Test
    public void sblogUserServiceCacheTest(){

        System.out.println("first query....");
        User user = userService.logon("jan", "jan1234");
        System.out.println("second query....");
        User user2 = userService.logon("jan", "jan1234");
    }
}
