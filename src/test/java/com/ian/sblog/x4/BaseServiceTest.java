package com.ian.sblog.x4;

import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext("classpath:applicationContext.xml")
public class BaseServiceTest extends UnitilsTestNG {

    @SpringApplicationContext
    protected ApplicationContext applicationContext;

}
