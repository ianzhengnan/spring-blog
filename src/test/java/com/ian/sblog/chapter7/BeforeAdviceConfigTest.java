package com.ian.sblog.chapter7;

import com.ian.sblog.chapter7.advice.Daxia;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeAdviceConfigTest {

    @Test
    public void proxy(){
        String configPath = "classpath:com/ian/sblog/chapter7/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Daxia daxia = (Daxia)ctx.getBean("daxia");
        daxia.kickTo("John");
    }

}
