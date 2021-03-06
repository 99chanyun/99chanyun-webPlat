package com.chanyun.service;

import java.util.List;

import com.chanyun.entity.User;


/**
* <p>Title: UserService.java</p>  

* <p>Description: 用户信息操作接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月26日 

* @version 1.0
 */
public interface UserService {
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public User add(User user);
	
	/**
	 * 编辑用户信息
	 * @param user
	 * @return
	 */
	public boolean edit(User user);
	
	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	public User queryUser(int userId);
	
	/**
	 * 通过用户名密码查询用户信息
	 * @param user
	 * @return
	 */
	public User queryUserByUserAccountAndPassword(User user);
	
	/**
	 * 查询功德榜数据
	 * @return
	 */
	public List<User> queryMeritsUserList();
	
	/**
	 * 
	 * @Title: queryUserCountByUserAccount   
	 * @Description: 根据 用户名查询用户数量
	 * @param: @param user
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int queryUserCountByUserAccount(String userAccount);
	
	/**
	 * 
	 * @Title: queryUserCountByUserPhone   
	 * @Description: 根据 用户手机号查询用户数量
	 * @param: @param user
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int queryUserCountByUserPhone(String userPhone);
}
