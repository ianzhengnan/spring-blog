package com.ian.sblog.dao;

import static com.ian.sblog.util.SBlogConstants.COMMENTTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ian.sblog.dao.provider.CommentDynaSqlProvider;
import com.ian.sblog.domain.Comment;

public interface CommentDao {

	@Delete("delete from " + COMMENTTABLE + " where id = #{id}")
	void removeById(Integer id);
	
	@SelectProvider(type = CommentDynaSqlProvider.class, method = "selectWithParams")
	List<Comment> selectByParams(Map<String, Object> params);
	
	@UpdateProvider(type = CommentDynaSqlProvider.class, method = "update")
	void updateComment(Comment comment);
	
	@InsertProvider(type = CommentDynaSqlProvider.class, method = "save")
	void save(Comment comment);
	
	@Select("select count(*) from " + COMMENTTABLE + " where article_id = #{articleId}")
	Integer count(Integer articleId);
	
	
}
