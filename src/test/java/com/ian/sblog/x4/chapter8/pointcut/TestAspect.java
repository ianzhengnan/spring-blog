package com.ian.sblog.x4.chapter8.pointcut;

import com.ian.sblog.x4.chapter8.aspectj.Gongfu;
import com.ian.sblog.x4.chapter8.aspectj.NormalGongfu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {

    @Test
    public void testPointCut(){
        String configPath = "com/ian/sblog/x4/chapter8/aspectj/pointcut/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Gongfu normalgongfu = (Gongfu) ctx.getBean("normalgongfu");
        Gongfu coolgongfu = (Gongfu) ctx.getBean("coolgongfu");
        coolgongfu.kickTo("张三");
        normalgongfu.kickTo("张三");
        coolgongfu.boxTo("李四");
        normalgongfu.boxTo("王五");
    }
}
