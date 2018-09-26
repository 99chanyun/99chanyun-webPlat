package com.chanyun.service;

import com.chanyun.common.PageInfo;
import com.chanyun.entity.Temple;

/**
* <p>Title: TempleService.java</p>  

* <p>Description: 寺庙数据接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月18日 

* @version 1.0
 */
public interface TempleService {
	/**
	 * 分页查询寺庙列表
	 * @param pageNum  页码
	 * @param pageSize 页面数据条数
	 * @param temple   寺庙查询信息
	 * @return
	 */
	public PageInfo<Temple> findTempleByPage(int pageNum,int pageSize,Temple temple);
	
	/**
	 * 编辑寺庙信息
	 * @param temple
	 * @return
	 */
	public boolean editTemple(Temple temple);
	
	/**
	 * 添加寺庙信息
	 * @param temple 寺庙 信息
	 * @return
	 */
	public Temple addTemple(Temple temple);
	
	/**
	 * 根据id查询寺庙信息
	 * @param templeId
	 * @return
	 */
	public Temple queryById(int templeId);
	
	
}
