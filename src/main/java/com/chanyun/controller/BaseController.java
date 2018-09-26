package com.chanyun.controller;

import com.chanyun.common.BaseResult;

/**
 * @Description: controller 公共方法类
 * @author liuyang
 * @data  2017-6-17 上午10:36:51
 *
 */
public class BaseController<T> {
	
	/**
	 * 返回json数据组装
	 * @param code
	 * @param message
	 * @return
	 */
	public BaseResult<T> result(String code, String message, T data){
		BaseResult<T> br = new BaseResult<T>();
		br.setCode(code);
		br.setMessage(message);
		br.setData(data);
		return br;
	}
}
