package com.ian.sblog.x4.chapter7.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 环绕增强
public class KickInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments(); //目标方法的入参
        String clientName = (String) args[0];
        System.out.println("first, bite " + clientName + "."); // before

        Object obj = invocation.proceed();

        System.out.println("after, bite you again!"); //after

        return obj;
    }
}
