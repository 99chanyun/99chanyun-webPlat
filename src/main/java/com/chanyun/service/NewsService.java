package com.chanyun.service;

import java.util.List;

import com.chanyun.common.PageInfo;
import com.chanyun.entity.News;


/**
* <p>Title: NewsService.java</p>  

* <p>Description: 新闻资讯页面</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月16日 

* @version 1.0
 */
public interface NewsService {
	/**
	 * 查询首页资讯列表数据
	 * @return
	 */
	public List<News> queryIndexNewsList();
	
	/**
	 * 分页查询资讯列表数据
	 * @return
	 */
	public PageInfo<News> queryNewsList(int pageNum,int pageSize,News news);
	
	/**
	 * 添加资讯数据
	 * @param News 
	 * @return
	 */
	public News add(News news);
	
	/**
	 * 修改资讯数据
	 * @param News
	 * @return
	 */
	public boolean edit(News news);
	
	/**
	 * 根据id查询资讯
	 * @param newsId
	 * @return
	 */
	public News queryNewsById(int newsId);
	
	/**
	 * 查询首页法会信息
	 * @return
	 */
	public News queryIndexCeremonies();
	
	/**
	 * 查询活动信息
	 * @return
	 */
	public List<News> queryIndexActivities();
	
	/**
	 * 查询寺庙资讯信息
	 * @param templeId
	 * @return
	 */
	public List<News> queryNewsByTempleId(int templeId);
	
	/**
	 * 根据资讯内容查询资讯内容
	 * @param news
	 * @return
	 */
	public List<News> queryNewsByTitle(String newsTitle);
}
