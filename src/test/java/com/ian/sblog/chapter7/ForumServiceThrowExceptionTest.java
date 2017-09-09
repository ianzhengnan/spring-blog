package com.ian.sblog.chapter7;

import com.ian.sblog.domain.Forum;
import com.ian.sblog.service.ForumService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ForumServiceThrowExceptionTest {

    @Test
    public void throwException() throws Exception{
        String configName = "classpath:com/ian/sblog/chapter7/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configName);

        ForumService forumService = (ForumService) ctx.getBean("forumService");
        try{
            forumService.removeForum(1);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try{
            forumService.updateForum(new Forum());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
