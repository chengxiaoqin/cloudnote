package com.cxq.service;

import java.util.List;

import com.cxq.model.Note;

public interface NoteService {
	//添加笔记
	void addNote(Note note);	
	//通过外键userId查询所有关联笔记内容
	List<Note> getNoteByUid(int i);
	//修改笔记
	void updateNote(Note note);
	//通过用户id获得笔记
	Note getNoteById(int i);
}
