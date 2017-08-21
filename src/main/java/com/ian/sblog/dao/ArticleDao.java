package com.ian.sblog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ian.sblog.dao.provider.ArticleDynaSqlProvider;
import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Comment;

import static com.ian.sblog.util.SBlogConstants.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ArticleDao {

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from " + ARTICLETABLE + " where id = #{id}")
	Article selectById(Integer id);
	
	/**
	 * 
	 * @param id
	 */
	@Delete("delete from " + ARTICLETABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	@SelectProvider(type = ArticleDynaSqlProvider.class, method = "selectWithParams")
	List<Article> selectByParams(Map<String, Object> params);
	
	/**
	 * 
	 * @param article
	 */
	@UpdateProvider(type = ArticleDynaSqlProvider.class, method = "updateArticle")
	void updateArticle(Article article);
	
	/**
	 * 
	 * @param article
	 */
	@InsertProvider(type = ArticleDynaSqlProvider.class, method = "save")
	void save(Article article);
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	@Select("select count(*) from " + ARTICLETABLE + " where create_by = #{userId}")
	Integer count(Integer userId);
	
	@Select("select * from " + ARTICLETABLE + " where user_id = #{userId} order by id desc limit 1")
	Integer getLastInsertArticleID(Integer userId);
	
	@Insert("insert into " + STAREDARTICLETABLE + "(article_id, user_id, create_at) values(#{articleId}, #{userId}, #{now})")
	void setStar(Integer articleId, Integer userId, Date now);
	
	@Delete("delete from " + STAREDARTICLETABLE + " where user_id = #{userId} and article_id = #{articleId}")
	void unStar(Integer articleId, Integer userId);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from " + COMMENTTABLE + " where article_id = #{id}")
	List<Comment> getComments(Integer id);
	
}
