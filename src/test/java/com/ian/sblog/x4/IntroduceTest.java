package com.ian.sblog.x4;

import com.ian.sblog.x4.chapter7.advice.Monitorable;
import com.ian.sblog.domain.Forum;
import com.ian.sblog.service.ForumService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroduceTest {

    @Test
    public void introduce() throws Throwable{
        String configPath = "com/ian/sblog/x4/chapter7/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) ctx.getBean("forumService");

        forumService.removeForum(10);
        forumService.updateForum(new Forum());

        // 开启监视性能功能
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);


        forumService.removeForum(11);
        forumService.updateForum(new Forum());
    }
}
