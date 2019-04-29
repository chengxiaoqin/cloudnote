package com.cxq.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxq.mapper.NoteMapper;
import com.cxq.model.Note;
import com.cxq.service.NoteService;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteMapper noteMapper;

	@Override
	public void addNote(Note note) {

		noteMapper.saveNote(note);

	}

	@Override
	public List<Note> getNoteByUid(int i) {
		List<Note> list = new ArrayList<Note>();
		list = noteMapper.getNoteByUid(i);
		return list;
	}

	@Override
	public void updateNote(Note note) {
		noteMapper.updateNote(note);
	}
	
	@Override
	public Note getNoteById(int i) {	
		return noteMapper.getNoteById(i);
	}
}
