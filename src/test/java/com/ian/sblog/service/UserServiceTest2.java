package com.ian.sblog.service;

import com.ian.sblog.domain.User;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import static org.hamcrest.core.IsEqual.equalTo;

@SpringApplicationContext("classpath:applicationContext-test.xml")
public class UserServiceTest2 extends UnitilsTestNG {

    @SpringBean("sblogUserService")
    private UserService userService;

    @Test
    @DataSet("UserService.SaveUsers.xls")
    public void loginSuccess(){
        User user = userService.logon("john", "john1234");
        MatcherAssert.assertThat(user.getUsername(), equalTo("john"));
    }
}
