package com.chanyun.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chanyun.common.Constants;
import com.chanyun.entity.OnlineMessage;
import com.chanyun.service.UserService;

/**
 * @Description:用户对外接口提供服务层
 * @author liuyang
 * @data  2017-6-17 上午10:10:32
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册/登陆初始化页面
	 * @param flag 注册登陆标识
	 * @return 返回页面
	 */
	@RequestMapping("/init")
	public String init(String flag){
		if("reg".equals(flag))
			return "/user/register";
		return "user/login";
	}
	
	
	/**
	 * 用户注册接口
	 * @param user 用户信息对象
	 * @return 返回json数据
	 */
	@ResponseBody
	@RequestMapping("/add")
	public String addUser(@RequestBody String params){
		OnlineMessage user = JSONObject.parseObject(params, OnlineMessage.class);
		//注册参数较验
		if(null == user || StringUtils.isBlank(user.getUserName()) || 
				StringUtils.isBlank(user.getMessageContent()))//必填参数较验不通过
			return returnBaseResult(Constants.RESULT_CODE_CHECK_FAIL, "用户名密码不能为空");
		boolean result = userService.add(user);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "注册成功");
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "注册失败，数据保存异常");
	}
}
