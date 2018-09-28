package com.chanyun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.entity.User;
import com.chanyun.service.UserService;

/**
 * @Description:用户对外接口提供服务层
 * @author liuyang
 * @data  2017-6-17 上午10:10:32
 *
 */
@Api(tags = "用户操作接口")
@RestController
@RequestMapping(value = "/api/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("用户登陆接口")
	@PostMapping("login")
	@ResponseBody
	public BaseResult<User> login(@RequestBody User user, HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute(Constants.USER_LOGIN_SESSION_KEY);
		if(null != userId || 0 != userId ){ //用户已经登陆过了
			return result(Constants.RESULT_CODE_SUCCESS, "用户已登陆", null);
		}
		User params = new User();
		params.setUserAccount(user.getUserAccount());
		params.setUserPassword(user.getUserName());
		User result = userService.queryUserByUserAccountAndPassword(params);
		if(null == result){
			return result(Constants.RESULT_CODE_CHECK_FAIL, "登陆失败，用户名密码不对", null);
		}
		//在session中存储用户id,做为用户登陆标识
		session.setAttribute(Constants.USER_LOGIN_SESSION_KEY, result.getId());
		//将密码隐藏
		result.setUserPassword(null);
		return result(Constants.RESULT_CODE_SUCCESS, "登陆成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("用户注册接口")
	@PostMapping("regist")
	@ResponseBody
	public BaseResult<User> regist(@RequestBody User user){
		user = userService.add(user);
		user.setUserPassword(null);
		return result(Constants.RESULT_CODE_SUCCESS, "注册成功", user);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("用户退出登陆接口")
	@PostMapping("loginOut")
	@ResponseBody
	public BaseResult<String> loginOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.USER_LOGIN_SESSION_KEY);
		return result(Constants.RESULT_CODE_SUCCESS, "退出登陆成功", null);
	}
	
}
