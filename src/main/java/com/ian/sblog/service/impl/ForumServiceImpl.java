package com.ian.sblog.service.impl;

import com.ian.sblog.domain.Forum;
import com.ian.sblog.service.ForumService;
import com.ian.sblog.x4.chapter8.annotation.NeedTest;

import java.sql.SQLException;

public class ForumServiceImpl implements ForumService {
    @Override
    @NeedTest // default is true, so don't need to add value
    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum" + forumId);

        /*try{
            Thread.currentThread().sleep(20);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }*/
//        throw new RuntimeException("运行异常");
    }

    @Override
    @NeedTest(value = false)
    public void updateForum(Forum forum) {
        System.out.println("模拟更新forum记录");

        /*try{
            Thread.currentThread().sleep(40);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }*/

//        throw new SQLException("数据库更新异常");
    }
}
