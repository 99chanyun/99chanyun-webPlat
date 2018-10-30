package com.chanyun.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.Merits;
import com.chanyun.service.MeritsService;
import com.chanyun.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户中心数据接口")
@RestController
@RequestMapping("/api/userCenter")
public class UserCenterController extends BaseController {
	@Autowired
	private MeritsService meritsService;
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("查询用户订单")
	@RequestMapping("meritsList")
	@ResponseBody
	public BaseResult<PageInfo<Merits>> queryMeritsList(@RequestBody QueryParams<Merits> params, HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute(Constants.USER_LOGIN_SESSION_KEY);
		if(null == userId) return result(Constants.RESULT_CODE_NOT_LOGIN, "用户未登陆", null);
		Merits merits = new Merits();
		merits.setUserId(userId);
		PageInfo<Merits> result = meritsService.findByPage(params.getPageNum(), params.getPageSize(), merits);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@ApiOperation("查询用户订单")
	@RequestMapping("userMeritsCount")
	@ResponseBody
	public BaseResult<List<Map>> queryUserMeritsCount(HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute(Constants.USER_LOGIN_SESSION_KEY);
		
		List<Map> result = meritsService.queryUserMeritsCount(userId);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
}
