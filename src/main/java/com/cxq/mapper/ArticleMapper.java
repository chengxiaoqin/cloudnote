package com.cxq.mapper;

import java.util.List;

import com.cxq.pojo.Article;

public interface ArticleMapper {
	//将文章保存至数据库中
	void saveArticle(Article article);
	//将数据库中的用户文章取出
	List<Article> queryArticles(int i);
	//更新文章
	void updateArticle(Article article);
}
