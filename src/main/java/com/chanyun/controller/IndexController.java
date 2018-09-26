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
import com.chanyun.entity.IndexBanner;
import com.chanyun.entity.News;
import com.chanyun.service.IndexBannerService;
import com.chanyun.service.NewsService;

/**
 * 

* <p>Title: IndexController.java</p>  
 
* <p>Description: 首页数据接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月26日 

* @version 1.0
 */
@Api(tags="首页数据接口获取")
@RestController
@RequestMapping("/index")
public class IndexController extends BaseController{
	@Autowired
	private IndexBannerService bannerService;
	@Autowired
	private NewsService newsService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("首页轮播图数据")
	@PostMapping("bannerList")
	@ResponseBody
	public BaseResult<List<IndexBanner>> queryIndexBanner(){
		List<IndexBanner> result = bannerService.queryIndexBannerList();
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("首页资讯信息")
	@PostMapping("newsList")
	@ResponseBody
	public BaseResult<List<News>> queryIndexNews(){
		List<News> result = newsService.queryIndexNewsList();
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("首页法会信息查询")
	@PostMapping("ceremonies")
	@ResponseBody
	public BaseResult<News> queryCeremonies(){
		News result = newsService.queryIndexCeremonies();
		if(null != result)
			return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
		return result(Constants.RESULT_CODE_FAIL, "查询失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("首页活动信息查询")
	@PostMapping("activity")
	@ResponseBody
	public BaseResult<List<News>> queryActivitis(){
		List<News> result = newsService.queryIndexActivities();
		if(null != result)
			return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
		return result(Constants.RESULT_CODE_FAIL, "查询失败", null);
	}
	
}
