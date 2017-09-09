package com.ian.sblog.chapter7;

import com.ian.sblog.chapter7.advice.Daxia;
import com.ian.sblog.chapter7.advice.KickBeforeAdvice;
import com.ian.sblog.chapter7.advice.NormalDaxia;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceTest {

    @Test
    public void before(){
        Daxia target = new NormalDaxia();
        BeforeAdvice advice = new KickBeforeAdvice();

        ProxyFactory pf = new ProxyFactory();
        pf.setInterfaces(target.getClass().getInterfaces()); // 这里设置了接口，就是使用jdk动态代理
        pf.setOptimize(true); // 这里设置了以后就是用cglib创建代理对象，上面的接口指定jdk也就不起作用了
        pf.setTarget(target);
        pf.addAdvice(advice);
        // pf.addAdvice(moreAdvice);

        Daxia proxy = (Daxia) pf.getProxy();
        proxy.boxTo("John");
        proxy.kickTo("Tom");
    }
}
