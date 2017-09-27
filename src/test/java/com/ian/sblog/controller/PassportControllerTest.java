package com.ian.sblog.controller;

import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import org.junit.Assert;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

@SpringApplicationContext({"classpath:springmvc-config.xml","classpath:applicationContext.xml"})
public class PassportControllerTest extends UnitilsTestNG {

    @SpringBeanByType
    private RequestMappingHandlerAdapter handlerAdapter;

    @SpringBeanByType
    private PassportController passportController;

    // 声明request对象的模拟对象
    private MockHttpServletRequest request;

    private MockHttpSession httpSession;

    private ModelAndView mv;

    @BeforeClass
    public void classSetup(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        httpSession = new MockHttpSession();
        mv = new ModelAndView();
    }

    @Test
    public void loginTest(){

        ModelAndView mav = passportController.handleLogin("jan", "jan1234", httpSession, mv);
        User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);

        Assert.assertNotNull(user);
        Assert.assertNotNull(mav);
        Assert.assertEquals(mav.getViewName(), "redirect:../main");
        Assert.assertEquals(user.getUsername(), "jan");
    }

}
