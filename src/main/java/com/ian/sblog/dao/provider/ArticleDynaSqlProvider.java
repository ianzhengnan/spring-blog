package com.ian.sblog.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.ian.sblog.domain.Article;

import static com.ian.sblog.util.SBlogConstants.ARTICLETABLE;

public class ArticleDynaSqlProvider {

	public String selectByParams(Map<String, Object> params) {
		
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(ARTICLETABLE);
				if(params.get("article") != null) {
					Article article = (Article)params.get("article");
					if (article.getSubject() != null && !article.getSubject().equals("") ) {
						WHERE(" subject like CONCAT('%', #{article.subject}, '%')");
					}
					if (article.getCategory() != null) {
						WHERE(" category_id = #{article.category.id}");
					}
					if(article.getStatus() != null && !article.getStatus().equals("")) {
						WHERE(" status = #{article.status}");
					}
				}
			}
		}.toString();
		
		if (params.get("orderBy") != null) {
			sql += " order by " + (String)params.get("orderBy");
		}
		
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
		}
		
		return sql;
	}
}
