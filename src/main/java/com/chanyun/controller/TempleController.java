package com.chanyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.entity.Temple;
import com.chanyun.service.TempleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "寺庙数据接口")
@RestController
@RequestMapping("/api/temple")
public class TempleController extends BaseController{
	@Autowired
	private TempleService templeService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙logo列表")
	@PostMapping("templeLogoList")
	@ResponseBody
	public BaseResult<List<Temple>> templeLogoList(){
		List<Temple> result = templeService.templeList();
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙入驻申请")
	@PostMapping("addTemple")
	@ResponseBody
	public BaseResult<List<Temple>> addTemple(@RequestBody Temple temple){
		temple = templeService.addTemple(temple);
		return result(Constants.RESULT_CODE_SUCCESS, "申请成功", temple);
	}
	
	
}
