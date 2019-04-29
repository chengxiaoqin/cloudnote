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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxq.model.Note;
import com.cxq.model.User;
import com.cxq.service.NoteService;
import com.cxq.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	public static final String HOME_PAGE = "homepage";
	public static final String MODIFY_PAGE = "inputModify";
	public static final String MODIFY_SUCCEED = "modifySucceed";
	public static final String REGISTER_SUCCEED = "registerSucceed";
	public static final String REGISTER_ERROR = "registerError";
	public static final String LOGIN_ERROR = "loginError";
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
	 * 注册用户
	 */
	@PostMapping("/register")
	public String addUser(User user) {
		int i = userService.checkUserName(user); // 检测数据库中是否有用户名重复
		if (i == 1) {
			return REGISTER_ERROR;
		}
		userService.addUser(user);
		return REGISTER_SUCCEED;
	}

	/*
	 * 登录用户
	 */
	@PostMapping("/loginUser")
	public String loginUser(User user, HttpServletResponse response ,HttpServletRequest request) {
		int i = userService.checkUser(user); // 检测用户名和密码是否正确
		if (i == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			return HOME_PAGE; // 跳转到主页
		}
		return LOGIN_ERROR;
	}

}
