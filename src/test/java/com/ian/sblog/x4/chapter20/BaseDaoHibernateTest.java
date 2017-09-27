package com.ian.sblog.x4.chapter20;

import org.hibernate.SessionFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.orm.hibernate.annotation.HibernateSessionFactory;

@HibernateSessionFactory("hibernate.cfg.xml") // 在这里指定配置文件，hibernate上下文只会创建一次，子类会重用这个父类，性能会大大提升
public class BaseDaoHibernateTest extends UnitilsTestNG {

    @HibernateSessionFactory
    protected SessionFactory sessionFactory;

    @Test
    public void testSessionFactory(){
        Assert.assertNotNull(sessionFactory);
    }
}
