package com.chanyun.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chanyun.dao.UserMapper;
import com.chanyun.entity.User;
import com.chanyun.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User add(User user) {
		int i = userMapper.insertSelective(user);
		if (i > 0) return user;
		return null;
	}
	
	@Override
	public boolean edit(User user) {
		int i = userMapper.updateByPrimaryKeySelective(user);
		if (i > 0) return true;
		return false;
	}
	
	@Override
	public User queryUser(int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

}
