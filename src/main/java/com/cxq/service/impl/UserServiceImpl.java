package com.cxq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxq.mapper.UserMapper;
import com.cxq.model.User;
import com.cxq.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public int checkUserName(User user) {
		int i;
		i = userMapper.checkUserName(user);
		return i;
	}

	@Override
	public int checkUser(User user) {
		int i;
		i = userMapper.checkUser(user);
		return i;
	}

	@Override
	public int queryId(String string) {
		int i;
		i = userMapper.queryId(string);
		return i;
	}
}
