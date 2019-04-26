package com.cxq.mapper;

import java.util.List;

import com.cxq.pojo.Users;

public interface UsersMapper {
	// 插入用户至数据库
	void insertUser(Users users);

	// 查询数据库中已有用户名是否有与name相同
	int checkUserName(Users users);

	// 查询用户名密码是否相同
	int checkUser(Users users);

	// 通过用户名查询id
	int queryId(String string);
}
