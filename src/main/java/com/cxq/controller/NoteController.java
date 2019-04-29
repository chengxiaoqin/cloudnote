package com.cxq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxq.model.Note;
import com.cxq.model.User;
import com.cxq.service.NoteService;
import com.cxq.service.UserService;

@Controller
@RequestMapping("/note")
public class NoteController {

	public static final String HOME_PAGE = "homepage";
	public static final String MODIFY_PAGE = "inputModify";
	public static final String MODIFY_SUCCEED = "modifySucceed";
	public static final String REGISTER_SUCCEED = "registerSucceed";
	public static final String REGISTER_ERROR = "registerError";
	public static final String LOGIN_ERROR = "loginError";
	public static final String SAVE_SUCCEED = "saveSucceed";
	public static final String UPDATE_PATE = "updateNote";
	@Autowired
	private UserService userService;
	@Autowired
	private NoteService noteService;

	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	/*
	 * 保存笔记
	 */
	@PostMapping("/saveNote")	//get和post,delete,put
	public String saveArticle(Note note, HttpServletRequest request) {
		int i;
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		i = userService.queryId(name);
		note.setUserId(i); // 添加至note的外键
		noteService.addNote(note);
		return SAVE_SUCCEED;
	}

	/*
	 * 显示之前已保存的文章
	 */
	@GetMapping("/showNote")
	public String showArticle(HttpServletRequest request, Model model) {
		int i;
		List<Note> list = new ArrayList<Note>();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		i = userService.queryId(name); 			// 通过用户名获得用户id
		list = noteService.getNoteByUid(i);		//通过userId查询所有关联笔记
		model.addAttribute("list", list);
		return UPDATE_PATE;
	}

	/*
	 * 跳转到修改页面
	 */
	@RequestMapping("/inputModify")
	public String getNote (@RequestParam("id") int id,Model model) {
		//根据id获得一个note
		Note note = noteService.getNoteById(id);
		model.addAttribute("note", note);
		return MODIFY_PAGE;
	}

	/*
	 * 保存修改
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam("id") int id,Note note, HttpServletRequest request) {
		note.setId(id);
		noteService.updateNote(note);
		return MODIFY_SUCCEED;
	}
}
