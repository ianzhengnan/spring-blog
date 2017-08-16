package com.ian.sblog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ian.sblog.domain.User;
import com.ian.sblog.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public void logon(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
