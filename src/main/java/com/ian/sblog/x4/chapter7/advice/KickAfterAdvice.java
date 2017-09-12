package com.ian.sblog.x4.chapter7.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class KickAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After all, kick you again!...hahaha...");
    }
}
