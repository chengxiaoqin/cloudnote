package com.cxq.pojo;

public class Article {
	private Integer art_id; // article主键
	private String title;
	private String article;
	private Integer id; // article外键，关联users

	public Integer getArt_id() {
		return art_id;
	}

	public void setArt_id(Integer art_id) {
		this.art_id = art_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Article [art_id=" + art_id + ", title=" + title + ", article=" + article + ", id=" + id + "]";
	}
	
}
