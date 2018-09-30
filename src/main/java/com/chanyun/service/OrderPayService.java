package com.chanyun.service;

import com.chanyun.common.BaseResult;
import com.chanyun.vo.CreateOrderVo;

/**

* <p>Title: OrderPayService.java</p>  

* <p>Description: 订单支付服务</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月30日 

* @version 1.0
 */
public interface OrderPayService {
	/**
	 * 订单支付请求
	 * @param createOrderVo
	 * @return
	 */
	public BaseResult<String> orderPay(CreateOrderVo createOrderVo);
}
