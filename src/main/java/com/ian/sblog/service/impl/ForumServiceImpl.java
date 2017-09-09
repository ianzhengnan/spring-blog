package com.ian.sblog.service.impl;

import com.ian.sblog.domain.Forum;
import com.ian.sblog.service.ForumService;

import java.sql.SQLException;

public class ForumServiceImpl implements ForumService {
    @Override
    public void removeForum(int forumId) {
        System.out.println("removing forum...");
        throw new RuntimeException("运行异常");
    }

    @Override
    public void updateForum(Forum forum) throws SQLException{
        System.out.println("updating forum...");
        throw new SQLException("数据库更新异常");
    }
}
