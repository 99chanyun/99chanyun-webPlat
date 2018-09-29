package com.chanyun.service;

import java.util.List;

import com.chanyun.entity.Bodhisattva;

/**
* <p>Title: BodhisattvaService.java</p>  

* <p>Description: 菩萨数据接口服务类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月29日 

* @version 1.0
 */
public interface BodhisattvaService {
	
	/**
	 * 根据寺庙查询菩萨列表
	 * @param params
	 * @return
	 */
	public List<Bodhisattva> queryBodhisattvaListByTempleId(int templeId);
}
