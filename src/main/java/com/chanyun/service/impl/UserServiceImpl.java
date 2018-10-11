package com.chanyun.service.impl;
import java.util.List;

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

	@Override
	public User queryUserByUserAccountAndPassword(User user) {
		List<User> userList = userMapper.selectByParams(user);
		if(null != userList && userList.size() > 0) return userList.get(0);
		return null;
	}

	@Override
	public List<User> queryMeritsUserList() {
		List<User> result = userMapper.selectByMerits();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.chanyun.service.UserService#queryUserCountByUserAccount(java.lang.String)
	 */
	@Override
	public int queryUserCountByUserAccount(String userAccount) {
		User user  = new User();
		user.setUserAccount(userAccount);
		int i = userMapper.selectCountByParames(user);
		return i;
	}

	/* (non-Javadoc)
	 * @see com.chanyun.service.UserService#queryUserCountByUserPhone(java.lang.String)
	 */
	@Override
	public int queryUserCountByUserPhone(String userPhone) {
		User user  = new User();
		user.setUserPhone(userPhone);
		int i = userMapper.selectCountByParames(user);
		return i;
	}

	

}
