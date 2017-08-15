package com.ian.sblog.dao;

import static com.ian.sblog.util.SBlogConstants.COMMENTTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ian.sblog.dao.provider.CommentDynaSqlProvider;
import com.ian.sblog.domain.Comment;

public interface CommentDao {

	@Delete("delete from " + COMMENTTABLE + " where id = #{id}")
	void removeById(Integer id);
	
	@SelectProvider(type = CommentDynaSqlProvider.class, method = "selectWithParam")
	List<Comment> selectByParams(Map<String, Object> params);
	
	@UpdateProvider(type = CommentDynaSqlProvider.class, method = "update")
	void updateComment(Comment comment);
	
	@Insert("insert into " + COMMENTTABLE + "(content, article_id, reply_comment_id, user_id, create_at, last_modify_at) "
			+ "values(#{comment.content}, #{comment.article.id}, #{comment.replyComment.id}, #{comment.createBy.id}, "
			+ "#{comment.createAt}, #{comment.lastModifyAt})")
	void save(Comment comment);
	
	@Select("select count(*) from " + COMMENTTABLE + " where article_id = #{articleId}")
	Integer count(Integer articleId);
	
	
}
