package com.ian.sblog.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.ian.sblog.domain.Comment;

import static com.ian.sblog.util.SBlogConstants.*;

public class CommentDynaSqlProvider {

	public String selectByParams(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(COMMENTTABLE);
				if(params.get("comment") != null) {
					Comment comment = (Comment)params.get("comment");
					if (comment.getArticle() != null) {
						WHERE(" article_id = #{comment.article.id}");
					}
				}
				ORDER_BY("create_at desc");
			}
		}.toString();
		
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
		}
		
		return sql;
	}
}
