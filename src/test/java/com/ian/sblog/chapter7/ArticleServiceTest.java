package com.ian.sblog.chapter7;

import com.ian.sblog.dao.ArticleDao;
import com.ian.sblog.service.ArticleService;
import com.ian.sblog.service.impl.ArticleServiceImpl;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.lang.reflect.Proxy;

@SpringApplicationContext("classpath:applicationContext.xml")
//通过JDK的方式获得代理对象
public class ArticleServiceTest extends UnitilsTestNG{

    @SpringBean("articleDao")
    private ArticleDao articleDao;

    @Test
    public void proxy(){
        // 修改了注入方法，改为构造器注入，不然不能注入DAO
        ArticleService target = new ArticleServiceImpl(articleDao);

        PerformanceHandler handler = new PerformanceHandler(target);

        ArticleService proxy = (ArticleService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );

        proxy.getArticleById(27);

    }
}
