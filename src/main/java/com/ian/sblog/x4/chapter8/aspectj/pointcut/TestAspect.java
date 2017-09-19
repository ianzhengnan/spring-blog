package com.ian.sblog.x4.chapter8.aspectj.pointcut;

import org.aspectj.lang.annotation.*;

@Aspect
public class TestAspect {

//    @AfterReturning("@annotation(com.ian.sblog.x4.chapter8.annotation.NeedTest)")
    @AfterReturning("execution(* com.ian.sblog.x4.chapter8.aspectj.Gongfu.*(..))")
    public void needTestFun(){
        System.out.println("-----Annotation NeedTest advice executed-----");
    }

    @Before("within(com.ian.sblog.x4.chapter8.aspectj.*) " + "&& execution( * boxTo(..))")
    public void composeTestFun(){
        System.out.println("----Compose before advice executed------");
    }

    @Pointcut("within(com.ian.sblog.x4.chapter8.aspectj.*)") //命名切点1
    private void inPackage(){ } // 只能在本class使用

    @Pointcut("execution(* kickTo(..))") //命名切点2
    protected void kickTo(){ } // 可以在当前包中的切面类，子切面类中使用

    @Pointcut("inPackage() && kickTo()")
    public void inPkgKickTo(){ } // 可以任意使用

    @After("inPkgKickTo()")
    public void testInPkgKickTo(){
        System.out.println("-----named pointcut executed----");
    }
}
