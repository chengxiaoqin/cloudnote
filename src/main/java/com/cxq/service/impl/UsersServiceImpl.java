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
		usersMapper.insertUser(users);
	}

	@Override
	public int checkUserName(Users users) {
		int i;
		i = usersMapper.checkUserName(users);
		return i;
	}

	@Override
	public int checkUser(Users users) {
		int i;
		i = usersMapper.checkUser(users);
		return i;
	}

	@Override
	public int queryId(String string) {
		int i;
		i = usersMapper.queryId(string);
		return i;
	}
}
