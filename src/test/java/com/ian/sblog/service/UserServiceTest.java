package com.ian.sblog.service;

import com.ian.sblog.dao.UserDao;
import com.ian.sblog.domain.User;
import com.ian.sblog.service.impl.UserServiceImpl;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;


@SpringApplicationContext("classpath:applicationContext-test.xml")
public class UserServiceTest extends UnitilsTestNG {

    private UserDao userDao;

    @BeforeClass
    public void init(){
        userDao = mock(UserDao.class);
    }

    // 事实上这个测试方法真正读取数据库
    @Test
    public void findUserByUserName(){

        // 模拟测试数据
        User user = new User();
        user.setUsername("tom");
        user.setPassword("tom1234");
        doReturn(user).when(userDao).selectByUsername("tom");

        UserService userService = new UserServiceImpl();

        // 通过spring测试框架提供的工具类为目标对象私有属性赋值
        ReflectionTestUtils.setField(userService, "userDao", userDao);

        User u = userService.getUserByUsername("tom");
        Assert.assertNotNull(u);
        MatcherAssert.assertThat(u.getUsername(), equalTo(user.getUsername()));

        // 验证交互行为
        verify(userDao, times(1)).selectByUsername("tom");
    }


}
