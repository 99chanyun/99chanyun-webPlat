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
import com.chanyun.common.util.CreateNoUtil;
import com.chanyun.entity.Bodhisattva;
import com.chanyun.entity.MeritsProduct;
import com.chanyun.entity.Temple;
import com.chanyun.service.BodhisattvaService;
import com.chanyun.service.MeritsProductService;
import com.chanyun.service.TempleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "寺庙数据接口")
@RestController
@RequestMapping("/api/temple")
public class TempleController extends BaseController{
	@Autowired
	private TempleService templeService;
	
	@Autowired
	private BodhisattvaService bodhisattvaService;
	
	@Autowired
	private MeritsProductService meritsProductService;
	
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
		temple.setStatus(Constants.TEMPLE_STATUE_APPLY);
		temple.setTempleNumber(Constants.TEMPLE_NUMBER_PREFIX+CreateNoUtil.createNo());
		temple = templeService.addTemple(temple);
		return result(Constants.RESULT_CODE_SUCCESS, "申请成功", temple);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙列表")
	@PostMapping("templeList")
	@ResponseBody
	public BaseResult<List<Temple>> templeList(){
		List<Temple> result = templeService.templeList();
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙菩萨列表")
	@PostMapping("bodhisatvvaList")
	@ResponseBody
	public BaseResult<List<Bodhisattva>> bodhisatvvaList(@ApiParam(name = "id",value = "寺庙id" ) @RequestBody Temple temple){
		List<Bodhisattva> result = bodhisattvaService.queryBodhisattvaListByTempleId(temple.getId());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙香型列表")
	@PostMapping("incenseList")
	@ResponseBody
	public BaseResult<List<MeritsProduct>> incenseList(@ApiParam(name = "id",value = "寺庙id" ) @RequestBody Temple temple){
		List<MeritsProduct> result = meritsProductService.queryMeritsByTempleIdAndType(Constants.MERITS_TYPE_INCENSE, temple.getId());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("寺庙佛灯供奉列表")
	@PostMapping("lampList")
	@ResponseBody
	public BaseResult<List<MeritsProduct>> lampList(@ApiParam(name = "id",value = "寺庙id" ) @RequestBody Temple temple){
		List<MeritsProduct> result = meritsProductService.queryMeritsByTempleIdAndType(Constants.MERITS_TYPE_LAMP, temple.getId());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
}
