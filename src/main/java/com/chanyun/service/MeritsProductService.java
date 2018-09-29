package com.chanyun.service;

import java.util.List;

import com.chanyun.entity.MeritsProduct;

/**
* <p>Title: MeritsProductService.java</p>  

* <p>Description: 功德项目数据服务类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月29日 

* @version 1.0
 */
public interface MeritsProductService {
	
	/**
	 * 根据寺庙与功德类型查询功德项目列表
	 * @param meritsType
	 * @param templeId
	 * @return
	 */
	public List<MeritsProduct> queryMeritsByTempleIdAndType(int meritsType, int templeId);
	
}
