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
import com.chanyun.entity.News;
import com.chanyun.entity.Temple;
import com.chanyun.entity.TempleIntroduce;
import com.chanyun.entity.TempleMonk;
import com.chanyun.service.NewsService;
import com.chanyun.service.TempleIntroduceService;
import com.chanyun.service.TempleMonkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@SuppressWarnings("rawtypes")
@Api(tags = "寺庙主页")
@RestController
@RequestMapping("/api/templeIndex")
public class TempleIndexController extends BaseController{
	@Autowired
	private TempleIntroduceService templeIntroduceService;
	
	@Autowired
	private TempleMonkService templeMonkService;
	
	@Autowired
	private NewsService newsService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙简介接口")
	@ApiParam(name="id",value="寺庙id")
	@PostMapping("/templeIntroduce")
	@ResponseBody
	public BaseResult<TempleIntroduce> templeIntroduce(@ApiParam(name="id",value="寺庙id") @RequestBody Temple temple){
		TempleIntroduce result = templeIntroduceService.queryTempleIntroduceByTempleId(temple.getId());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙僧人列表接口")
	@ApiParam(name="id",value="寺庙id")
	@PostMapping("/templeMonk")
	@ResponseBody
	public BaseResult<TempleIntroduce> templeMonk(@ApiParam(name="id",value="寺庙id") @RequestBody Temple temple){
		List<TempleMonk> result = templeMonkService.queryByTempleId(temple.getId());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙通告接口")
	@ApiParam(name="id",value="寺庙id")
	@PostMapping("/templeNews")
	@ResponseBody
	public BaseResult<TempleIntroduce> templeNews(@ApiParam(name="id",value="寺庙id") @RequestBody Temple temple){
		List<News> result = newsService.queryNewsByTempleId(temple.getId());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
		
}
