package com.chanyun.service;

import java.util.List;

import com.chanyun.common.PageInfo;
import com.chanyun.entity.IndexBanner;


/**
* <p>Title: IndexBannerService.java</p>  

* <p>Description: indexBanner 数据接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月16日 

* @version 1.0
 */
public interface IndexBannerService {
	/**
	 * 查询首页banner列表数据
	 * @return
	 */
	public List<IndexBanner> queryIndexBannerList();
	
	/**
	 * 分页查询banner列表
	 * @param pageNum
	 * @param pageSize
	 * @param indexBanner
	 * @return
	 */
	public PageInfo<IndexBanner> queryIndexBannerByPage(int pageNum,int pageSize,IndexBanner indexBanner);
	
	/**
	 * 添加首页banner数据
	 * @param indexBanner 
	 * @return
	 */
	public IndexBanner add(IndexBanner indexBanner);
	
	/**
	 * 修改首页banner数据
	 * @param indexBanner
	 * @return
	 */
	public boolean edit(IndexBanner indexBanner);
	
	/**
	 * 根据id查询banner信息
	 * @param bannerId
	 * @return
	 */
	public IndexBanner queryIndexBannerById(int bannerId);
}
