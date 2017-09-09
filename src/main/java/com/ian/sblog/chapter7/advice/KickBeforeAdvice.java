package com.ian.sblog.chapter7.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class KickBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String badGuyName = (String) args[0];
        System.out.println("Bite you " + badGuyName + ".");
    }
}
