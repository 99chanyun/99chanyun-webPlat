package com.chanyun.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
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
import com.chanyun.common.util.CreateNoUtil;
import com.chanyun.entity.Merits;
import com.chanyun.entity.MeritsDetail;
import com.chanyun.entity.MeritsProduct;
import com.chanyun.service.MeritsDetailService;
import com.chanyun.service.MeritsProductService;
import com.chanyun.service.MeritsService;
import com.chanyun.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="功德项目订单类")
@RestController
@RequestMapping("/api/user/merits")
@Slf4j
public class MeritsController extends BaseController {
	
	@Autowired
	private MeritsService meritsService;
	@Autowired
	private UserService userService;
	@Autowired
	private MeritsProductService meritsProductService;
	@Autowired
	private MeritsDetailService meritsDetailService;
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("用户功德订单提交")
	@PostMapping("applyMerits")
	@ResponseBody
	public BaseResult<Merits> applyMerits(@RequestBody MeritsDetail meritsDetail, HttpServletRequest request){
		log.info("------------------进入功德事件提交---------------");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute(Constants.USER_LOGIN_SESSION_KEY);
		if(null == userId) return result(Constants.RESULT_CODE_NOT_LOGIN, "订单提交失败,用户未登陆", null);
		Merits merits = meritsDetail.getMerits(); 
		//订单初始值设置
//		merits.setApplyTime(new Date());
		merits.setMeritsStatus(Constants.MERITS_STATUS_APPLY);
		merits.setUserId(userId);
		merits.setMeritsNumber(Constants.MERITS_NUMBER_PREFIX+CreateNoUtil.createNo());
		MeritsProduct meritsProduct = meritsProductService.queryById(merits.getMeritsProductId());
		if(null == meritsProduct){
			log.info("功德项目不存在====id: "+merits.getMeritsProductId());
			return result(Constants.RESULT_CODE_CHECK_FAIL, "功德项目不存在", null);
		}
		merits.setMeritsName(meritsProduct.getMeritsName());
		merits.setMeritsType(meritsProduct.getMeritsType());
		merits.setMeritsAccount(meritsProduct.getSalePrice());
		log.info("--------------------功德事件入库----------------------------功德事件编号"+merits.getMeritsNumber());
		Merits result = meritsService.addMerits(merits);
		if(null == result) return result(Constants.RESULT_CODE_FAIL, "订单提交失败", result);
		meritsDetail.setMeritsId(result.getId());
		meritsDetail.setCreateTime(new Date());
		MeritsDetail resultDetail = meritsDetailService.insertMeritsDetail(meritsDetail);
		if(null == resultDetail) return result(Constants.RESULT_CODE_FAIL, "订单详情提交失败", resultDetail);
		return result(Constants.RESULT_CODE_SUCCESS, "订单提交成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("功德项目页面功德订单查询")
	@PostMapping("meritsListForProductPage")
	@ResponseBody
	public BaseResult<List<Merits>> meritsListForProductPage(){
		List<Merits> result = meritsService.queryMeritsListForProductPage();
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("用户功德簿查询")
	@PostMapping("orderList")
	@ResponseBody
	public BaseResult<PageInfo<Merits>> meritsListForUserPage(@RequestBody QueryParams<Merits> params, HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute(Constants.USER_LOGIN_SESSION_KEY);
		if(null == userId) return result(Constants.RESULT_CODE_NOT_LOGIN, "订单提交失败,用户未登陆", null);
		PageInfo<Merits> result = meritsService.queryMeritsListForUserPage(params.getPageNum(), params.getPageSize(), userId);
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("订单详情说明")
	@PostMapping("meritsDetail")
	@ResponseBody
	public BaseResult<Merits> meritsDetail(@ApiParam(name="meritsNumber", value="查询条件订单编号") @RequestBody Merits merits){
		if(StringUtils.isEmpty(merits.getMeritsNumber())){
			return result(Constants.RESULT_CODE_CHECK_FAIL, "订单编号参数错误 ", merits);
		}
		
		Merits result = meritsService.queryMeritsByMeritsNumber(merits.getMeritsNumber());
		return result(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("订单支付是否成功")
	@PostMapping("meritsIsSuccess")
	@ResponseBody
	public BaseResult<Merits> meritsIsSuccess(@ApiParam(name="meritsNumber", value="查询条件订单编号") @RequestBody Merits merits){
		if(StringUtils.isEmpty(merits.getMeritsNumber())){
			return result(Constants.RESULT_CODE_CHECK_FAIL, "订单编号参数错误 ", merits);
		}
		
		Merits result = meritsService.queryMeritsIsPayByMeritsNumber(merits.getMeritsNumber());
		if(null == result) return result(Constants.RESULT_CODE_UNPAY, "未支付", result);
		return result(Constants.RESULT_CODE_SUCCESS, "支付成功", result);
	}
}
