package com.ian.sblog.service;

import com.ian.sblog.domain.Forum;

import java.sql.SQLException;

public interface ForumService {

    void removeForum(int forumId);

    void updateForum(Forum forum) throws SQLException;
}
