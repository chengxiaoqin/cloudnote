package com.cxq.mapper;

import java.util.List;

import com.cxq.model.Note;

public interface NoteMapper {
	// 将笔记保存至数据库中
	void saveNote(Note note);

	// 将数据库中的用户笔记取出
	List<Note> getNoteByUid(int i);

	// 更新笔记
	void updateNote(Note note);
	//通过id获得note
	Note getNoteById(int i);

	
}
