package com.chanyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
}
