package com.ian.sblog.chapter7;

import com.ian.sblog.dao.ArticleDao;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz, ArticleDao articleDao){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        Class[] classes = { ArticleDao.class };
        Object[] objs = { articleDao };
        return enhancer.create(classes, objs);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(obj, args);
        PerformanceMonitor.end();
        return result;
    }
}
