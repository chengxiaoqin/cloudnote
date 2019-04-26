package com.cxq.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxq.pojo.Article;
import com.cxq.pojo.Users;
import com.cxq.service.ArticleService;
import com.cxq.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	public static final String HOME_PAGE = "homepage";
	public static final String MODIFY_PAGE = "inputModify";
	public static final String MODIFY_SUCCEED = "modifySucceed";
	public static final String REGISTER_SUCCEED = "registerSucceed";
	public static final String REGISTER_ERROR = "registerError";
	public static final String LOGIN_ERROR = "loginError";
	public static final String SAVE_SUCCEED = "saveSucceed";
	public static final String UPDATE_PATE = "updateArticle";
	@Autowired
	private UsersService usersService;
	@Autowired
	private ArticleService articleService;

	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	/**
	 * 注册用户
	 */
	@RequestMapping("/addUser")
	public String addUser(Users users) {
		int i = usersService.checkUserName(users); // 检测数据库中是否有用户名重复
		if (i == 1) {
			return REGISTER_ERROR;
		}
		usersService.addUser(users);
		return REGISTER_SUCCEED;
	}

	/**
	 * 登录用户
	 */
	@RequestMapping("/loginUser")
	public String loginUser(Users users, HttpServletResponse response) {
		int i = usersService.checkUser(users); // 检测用户名和密码是否正确
		if (i == 1) {
			Cookie cookie = new Cookie("name", users.getName()); // 保存用户名至cookie
			response.addCookie(cookie);
			return HOME_PAGE; // 跳转到主页
		}
		return LOGIN_ERROR;
	}

	/*
	 * 保存文章
	 */
	@RequestMapping("/saveArticle")
	public String saveArticle(Article article, HttpServletRequest request) {
		int i;
		Cookie[] cookies = request.getCookies(); // 通过cookie键获得值
		String name = "";
		for (Cookie cookie : cookies) {
			switch (cookie.getName()) {
			case "name":
				name = cookie.getValue();
				break;
			default:
				break;
			}
		}
		i = usersService.queryId(name); // 通过用户名获得用户id
		article.setId(i); // 添加至article的外键
		articleService.addArticle(article);
		return SAVE_SUCCEED;
	}

	/*
	 * 显示之前已保存的文章
	 */
	@RequestMapping("/showArticle")
	public String showArticle(HttpServletRequest request, Model model) {
		int i;
		List<Article> list = new ArrayList<Article>();
		Cookie[] cookies = request.getCookies(); // 通过cookie键获得值
		String name = "";
		for (Cookie cookie : cookies) {
			switch (cookie.getName()) {
			case "name":
				name = cookie.getValue();
				break;
			default:
				break;
			}
		}
		i = usersService.queryId(name); // 通过用户名获得用户id
		list = articleService.queryArticle(i);
		model.addAttribute("list", list);
		return UPDATE_PATE;
	}

	/*
	 * 跳转到更改页面
	 */
	@RequestMapping("/inputModify")
	public String inputModify(@RequestParam("id") int art_id,HttpServletResponse response) {
		String aid = Integer.toString(art_id);
		Cookie cookie = new Cookie("aid", aid);
		response.addCookie(cookie);
		return MODIFY_PAGE;
	}

	/*
	 * 保存修改
	 */
	@RequestMapping("/modify")
	public String modify(Article article, HttpServletRequest request) {
		int i;
		Cookie[] cookies = request.getCookies();
		String aid = "";
		for (Cookie cookie : cookies) {
			switch (cookie.getName()) {
			case "aid":
				aid = cookie.getValue();
				break;
			default:
				break;
			}
		}
		i = Integer.parseInt(aid);
		article.setArt_id(i);
		articleService.updateArticle(article);
		return MODIFY_SUCCEED;
	}
}
