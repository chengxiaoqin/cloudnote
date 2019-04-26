package com.cxq.service;

import java.util.List;

import com.cxq.pojo.Article;

public interface ArticleService {
	//添加文章
	void addArticle(Article article);	
	//通过外键id查询所有关联文章内容
	List<Article> queryArticle(int i);
	//修改文章
	void updateArticle(Article article);
}
