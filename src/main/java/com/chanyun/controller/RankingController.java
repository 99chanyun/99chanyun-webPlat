package com.chanyun.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.entity.User;
import com.chanyun.service.UserService;

@Api(tags = "功德榜")
@RestController
@RequestMapping("/api/ranking")
public class RankingController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("功德榜数据查询")
	@PostMapping("list")
	@ResponseBody
	public BaseResult<List<User>> list(){
		List<User> result = userService.queryMeritsUserList();
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
}
