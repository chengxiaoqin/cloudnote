package com.cxq.model;

public class Note {

	private Integer id;  
	private String title;
	private String content;
	private Integer userId; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setArticle(String article) {
		this.content = article;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Article [art_id=" + id + ", title=" + title + ", article=" + content + ", id=" + userId + "]";
	}

}
