package com.cxq.mapper;

import java.util.List;

import com.cxq.pojo.Users;

public interface UsersMapper {
	//插入用户至数据库
	void insertUser(Users users);
	//返回所有name
	List<String> checkUserName();
	//查询用户名密码是否相同
	int checkUser(Users users);
}
