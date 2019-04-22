package com.cxq.service;

import com.cxq.pojo.Users;

public interface UsersService {

	void addUser(Users users);
	
	int checkUserName(Users users);

	int checkUser(Users users);
	
}
