package com.ian.sblog.x4.chapter8.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 定义切面类advisor
@Aspect
public class PreBoxingAspect {

    // 定义切点pointcut和增强advice
    @Before("execution(* boxTo(..))")
    public void beforeBoxing(){
        System.out.println("先来个七伤拳！");
    }
}
