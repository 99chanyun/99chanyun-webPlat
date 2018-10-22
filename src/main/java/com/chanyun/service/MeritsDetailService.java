package com.chanyun.service;

import com.chanyun.entity.MeritsDetail;

/**
 * 

* <p>Title: MeritsDetailService.java</p>  

* <p>Description: 功德订单详情数据服务接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年10月11日 

* @version 1.0
 */
public interface MeritsDetailService {
	/**
	 * 根据功德订单id查询订单详情
	 * @param meritsId
	 * @return
	 */
	public MeritsDetail queryMeritsDetailByMeritsId(int meritsId);
	
	/**
	 * 插入或者更新操作
	 * @param meritsDetail
	 * @return
	 */
	public MeritsDetail updateOrInsertMertsDetail(MeritsDetail meritsDetail);
	
	/**
	 * 插入操作
	 * @param meritsDetail
	 * @return
	 */
	public MeritsDetail insertMeritsDetail(MeritsDetail meritsDetail);
}
