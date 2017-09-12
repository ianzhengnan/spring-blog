package com.ian.sblog.x4;

import com.ian.sblog.dao.ArticleDao;
import com.ian.sblog.service.ArticleService;
import com.ian.sblog.service.impl.ArticleServiceImpl;
import com.ian.sblog.x4.chapter7.CglibProxy;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

@SpringApplicationContext("classpath:applicationContext.xml")
//通过CGlib的方式获得代理对象
public class ArticleServiceCGLibTest extends UnitilsTestNG {

    @SpringBean("articleDao")
    private ArticleDao articleDao;

    @Test
    public void proxy(){
        CglibProxy proxy = new CglibProxy();
        ArticleService articleService = (ArticleService) proxy.getProxy(ArticleServiceImpl.class, articleDao);
        articleService.getArticleById(27);
    }
}
