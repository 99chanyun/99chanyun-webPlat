package com.chanyun.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.util.CreateNoUtil;
import com.chanyun.entity.Merits;
import com.chanyun.entity.User;
import com.chanyun.service.MeritsService;
import com.chanyun.service.UserService;

import io.swagger.annotations.Api;

@Api("功德项目订单类")
@RestController
@RequestMapping("/api/user/merits")
public class MeritsController extends BaseController {
	
	@Autowired
	private MeritsService meritsService;
	@Autowired
	private UserService userService;
	
	
	public BaseResult<Merits> addMerits(@RequestBody Merits merits, HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute(Constants.USER_LOGIN_SESSION_KEY);
		if(null == userId) return result(Constants.RESULT_CODE_CHECK_FAIL, "订单提交失败,用户未登陆", null);
		//订单初始值设置
		merits.setApplyTime(new Date());
		merits.setMeritsStatus(Constants.MERITS_STATUS_APPLY);
		merits.setUserId(userId);
		merits.setMeritsNumber(Constants.MERITS_NUMBER_PREFIX+CreateNoUtil.createNo());
		Merits result = meritsService.addMerits(merits);
		if(null == result) return result(Constants.RESULT_CODE_FAIL, "订单提交失败", result);
		return result(Constants.RESULT_CODE_SUCCESS, "订单提交成功", result);
	}
	
	
	public BaseResult<List<Merits>> meritsList(){
		meritsService.
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", null);
	}
	
	
}
