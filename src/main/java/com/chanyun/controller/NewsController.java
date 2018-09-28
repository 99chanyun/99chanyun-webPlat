package com.chanyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.News;
import com.chanyun.entity.Temple;
import com.chanyun.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "网站资讯数据接口")
@RestController
@RequestMapping("/api/news")
public class NewsController extends BaseController {
	@Autowired
	private NewsService newsService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("禅韵资讯接口")
	@PostMapping("/newsList")
	@ResponseBody
	public BaseResult<PageInfo<News>> newsList(@RequestBody QueryParams request){
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(), new News());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("佛学入门接口")
	@PostMapping("/buddhismList")
	@ResponseBody
	public BaseResult<PageInfo<News>> buddhismList(@RequestBody QueryParams request){
		News params  = new News();
		params.setNewsType(Constants.NEWS_TYPE_BUDDHISM);
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(), params);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("政策法规接口")
	@PostMapping("/statuteList")
	@ResponseBody
	public BaseResult<PageInfo<News>> statuteList(@RequestBody QueryParams request){
		News params  = new News();
		params.setNewsType(Constants.NEWS_TYPE_STATUTE);
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(), params);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("佛门动态接口")
	@PostMapping("/dynamicList")
	@ResponseBody
	public BaseResult<PageInfo<News>> dynamicList(@RequestBody QueryParams request){
		News params  = new News();
		params.setNewsType(Constants.NEWS_TYPE_DYNAMIC);
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(), params);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("禅韵活动接口")
	@PostMapping("/activityList")
	@ResponseBody
	public BaseResult<PageInfo<News>> activityList(@RequestBody QueryParams request){
		News params  = new News();
		params.setNewsType(Constants.NEWS_TYPE_ACTIVITY);
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(), params);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("法事法会接口")
	@PostMapping("/ceremoniesList")
	@ResponseBody
	public BaseResult<PageInfo<News>> ceremoniesList(@ApiParam(name="id",value="实体查询条件寺庙id") @RequestBody QueryParams<Temple> request){
		News params  = new News();
		params.setNewsType(Constants.NEWS_TYPE_CEREMONIES);
		params.setNewsTempleid(request.getBean().getId());
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(), params);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
}
