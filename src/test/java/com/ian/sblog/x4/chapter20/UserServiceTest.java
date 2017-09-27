package com.ian.sblog.x4.chapter20;

import com.ian.sblog.service.CategoryService;
import com.ian.sblog.service.UserService;
import com.ian.sblog.x4.BaseServiceTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByName;
import org.unitils.spring.annotation.SpringBeanByType;

public class UserServiceTest extends BaseServiceTest {

    @SpringBean("sblogUserService")
    private UserService userService;

    @SpringBeanByType
    private UserService userService2;

    @SpringBeanByName // CategoryService里必须用@Service("categoryService")注解
    private CategoryService categoryService;

    @Test
    public void testUserService(){
        Assert.assertNotNull(applicationContext);
        Assert.assertNotNull(userService);
        Assert.assertNotNull(userService.logon("jan", "jan1234"));
        Assert.assertNotNull(userService2);
        Assert.assertNotNull(categoryService);
    }
}
