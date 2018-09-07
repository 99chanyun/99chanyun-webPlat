package com.chanyun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chanyun.dao.OnlineMessageMapper;
import com.chanyun.entity.OnlineMessage;

/**
 * 
 * @Description:用户数据操作服务层
 * @author liuyang
 * @data  2017-6-17 上午10:10:05
 *
 */
@Service
public class UserService {
	@Autowired
	private OnlineMessageMapper userMapper;
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean add(OnlineMessage user){
		int result = userMapper.insert(user);
		if(result > 0) return true;
		return false;
	}
	
	/**
	 * 查询用户
	 * @param userName
	 * @param userPwd
	 * @return
	 */
//	public boolean checkUserNameAndPassword(String userName,String userPwd){
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("userName", userName);
//		params.put("userPwd", userPwd);
//		List<User> list= userMapper.selectByParams(params);
//		if(null != list && list.size()>0) return true;
//		return false;
//	} 
}
