package com.cxq.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxq.mapper.UsersMapper;
import com.cxq.pojo.Users;
import com.cxq.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void addUser(Users users) {
		this.usersMapper.insertUser(users);
	}
	@Override
	public int checkUserName(Users users){
		String name=users.getName();
		List<String> list=this.usersMapper.checkUserName();
		for (String string : list) {
			if(name.equals(string))
				return 1;
		}
		return 0;
	}
	@Override
	public int checkUser(Users users){
		int i;
		i=this.usersMapper.checkUser(users);
		return i;
	}
}
