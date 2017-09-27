package com.ian.sblog.controller;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.hamcrest.CoreMatchers.containsString;

@SpringApplicationContext({"classpath:springmvc-config.xml","classpath:applicationContext.xml",
        "classpath:rest-template.xml"})
public class PassportControllerTest2 extends UnitilsTestNG {

    @SpringBeanByType
    private RestTemplate restTemplate;

    @SpringBeanByType
    private PassportController passportController;

    @Test
    public void loginTest() throws Exception{

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "jan");
        map.add("password", "jan1234");

        // 发送客户端访问请求
        String result = restTemplate.postForObject(
                "http://localhost:8080/account/login", map, String.class
        );

        Assert.assertNotNull(result);
        MatcherAssert.assertThat(result, containsString("Welcome"));
    }
}
