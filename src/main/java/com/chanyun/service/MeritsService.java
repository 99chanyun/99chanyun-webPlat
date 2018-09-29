package com.chanyun.service;

import java.util.List;

import com.chanyun.common.PageInfo;
import com.chanyun.entity.Merits;

/**
 * 

* <p>Title: MeritsService.java</p>  

* <p>Description: 功德事件数据接口服务层</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月16日 

* @version 1.0
 */
public interface MeritsService {
	
	/**
	 * 分页查询功德事件
	 * @param merits
	 * @return
	 */
	public PageInfo<Merits> findByPage(int pageNum, int pageSize,Merits merits);
	
	/**
	 * 功德订单查询
	 * @param meritsNumber 功德编号
	 * @return
	 */
	public Merits queryMeritsByMeritsNumber(String meritsNumber);
	
	/**
	 * 添加功德记录
	 * @param merits
	 * @return
	 */
	public Merits addMerits(Merits merits);
	
	/**
	 * 修改功德记录状态
	 * @param meritsStatus
	 * @return
	 */
	public Merits updateStatusMerits(int meritsStatus,int id);
	
	/**
	 * 
	 * @return
	 */
	public List<Merits> queryMeritsListForProductPage();
}
