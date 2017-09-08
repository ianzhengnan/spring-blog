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
public class ArticleServiceTest extends UnitilsTestNG{

    @SpringBean("articleDao")
    private ArticleDao articleDao;

    @Test
    public void proxy(){
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
