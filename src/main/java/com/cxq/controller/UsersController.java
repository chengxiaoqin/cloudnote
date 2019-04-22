package com.cxq.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxq.pojo.Users;
import com.cxq.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	/**
	 * 注册用户
	 */
	@RequestMapping("/addUser")
	public String addUser(Users users){
		int i=this.usersService.checkUserName(users);		//检测数据库中是否有用户名重复
		if(i==1){
			return "registerError";							
		}
		this.usersService.addUser(users);
		return "ok";
	}
	/**
	 * 登录用户
	 */
	@RequestMapping("/loginUser")
	public String loginUser(Users users){
		int i=this.usersService.checkUser(users);	//检测用户名和密码是否正确
		if(i==1){
			return "ok";
		}
		return "loginError";
	}
}
	

