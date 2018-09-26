package com.chanyun.service;

import com.chanyun.entity.TempleIntroduce;

/**
* <p>Title: TempleIntroduceService.java</p>  

* <p>Description: 寺庙介绍数据操作接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月19日 

* @version 1.0
 */
public interface TempleIntroduceService {
	/**
	 * 添加寺庙简介
	 * @param templeIntroduce
	 * @return
	 */
	public TempleIntroduce add(TempleIntroduce templeIntroduce);
	
	/**
	 * 修改寺庙简介信息
	 * @param templeIntroduce
	 * @return
	 */
	public boolean edit(TempleIntroduce templeIntroduce);
	
	/**
	 * 根据寺庙id查询寺庙简介
	 * @param templeId
	 * @return
	 */
	public TempleIntroduce queryTempleIntroduceByTempleId(int templeId);
	
	
	/**
	 * 根据id查询寺庙简介信息
	 * @param templeIntroduceId
	 * @return
	 */
	public TempleIntroduce queryTempleInttroduceById(int templeIntroduceId);
}
