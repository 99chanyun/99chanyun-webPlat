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
import com.chanyun.entity.Merits;
import com.chanyun.entity.News;
import com.chanyun.service.MeritsService;
import com.chanyun.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "搜索接口")
@RestController
@RequestMapping("/api/search")
public class SearchController extends BaseController{
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private MeritsService meritsService;
	
	
	/**
	 * 根据资讯标题模糊查询资讯内容
	 * @param news
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ApiOperation("资讯搜索接口")
	@PostMapping("newsList")
	@ResponseBody
	public BaseResult<List<News>> queryNewsListByTitle(@ApiParam(name="news",value="查询条件资讯标题") @RequestBody News news){
		List<News> result = newsService.queryNewsByTitle(news.getNewsTitle());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("功德订单搜索接口接口")
	@PostMapping("merits")
	@ResponseBody
	public BaseResult<Merits> queryMeritsByNumber(@ApiParam(name="merits",value="功德订单编号查询") 
		@RequestBody Merits merits){
		Merits result = meritsService.queryMeritsByMeritsNumber(merits.getMeritsNumber());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
}
