package com.chanyun.service;

import java.util.List;

import com.chanyun.common.PageInfo;
import com.chanyun.entity.TempleMonk;
import com.github.pagehelper.Page;

/**
* <p>Title: TempleMonkService.java</p>  

* <p>Description: 寺庙僧人数据操作接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月20日 

* @version 1.0
 */
public interface TempleMonkService {
	/**
	 * 添加寺庙僧人
	 * @param templeMonk
	 * @return
	 */
	public TempleMonk add(TempleMonk templeMonk);
	
	/**
	 * 编辑寺庙僧人
	 * @param templeMonk
	 * @return
	 */
	public boolean edit(TempleMonk templeMonk);
	
	/**
	 * 分页查询僧人列表
	 * @param pageNum
	 * @param pageSize
	 * @param templeMonk
	 * @return
	 */
	public PageInfo<TempleMonk> queryByPage(int pageNum,int pageSize,TempleMonk templeMonk);
	
	/**
	 * 根据id查询僧人信息
	 * @param monkId
	 * @return
	 */
	public TempleMonk queryById(int monkId);
	
	/**
	 * 根据寺庙id查询寺庙列表
	 * @param templeId
	 * @return
	 */
	public List<TempleMonk> queryByTempleId(int templeId);
	
}
