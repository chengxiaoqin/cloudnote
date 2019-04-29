package com.cxq.service;

import com.cxq.model.User;

public interface UserService {

	void addUser(User user);

	int checkUserName(User user);

	int checkUser(User user);
	
	// 通过用户名查询id
	int queryId(String string);
}
