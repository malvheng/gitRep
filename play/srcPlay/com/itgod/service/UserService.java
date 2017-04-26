package com.itgod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itgod.dao.UserMapper;
import com.itgod.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public String show() {
		return "Hello World!";
	}

	public User showDao(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public void insert(User user) {
		userMapper.insert(user);
	}

}
