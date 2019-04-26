package com.cxq.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxq.mapper.ArticleMapper;
import com.cxq.pojo.Article;
import com.cxq.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public void addArticle(Article article) {

		articleMapper.saveArticle(article);

	}

	@Override
	public List<Article> queryArticle(int i) {
		List<Article> list = new ArrayList<Article>();
		list = articleMapper.queryArticles(i);
		return list;
	}

	@Override
	public void updateArticle(Article article) {
		articleMapper.updateArticle(article);
	}
}
