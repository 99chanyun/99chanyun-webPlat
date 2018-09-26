package com.chanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.TempleMapper;
import com.chanyun.entity.Temple;
import com.chanyun.service.TempleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class TempleServiceImpl implements TempleService {
	@Autowired
	private TempleMapper mapper;

	@Override
	public PageInfo<Temple> findTempleByPage(int pageNum, int pageSize,
			Temple temple) {
		PageHelper.startPage(pageNum, pageSize);
		PageHelper.orderBy("create_time desc");
		Page<Temple> sqlResult=mapper.selectByPage(temple);
		PageInfo<Temple> result = new PageInfo<Temple>(sqlResult);
		return result;
	}

	@Override
	public boolean editTemple(Temple temple) {
		int i = mapper.updateByPrimaryKeySelective(temple);
		if(i>0) return true;
		return false;
	}

	@Override
	public Temple addTemple(Temple temple) {
		int i = mapper.insertSelective(temple);
		if(i>0) return temple;
		return null;
	}

	@Override
	public Temple queryById(int templeId) {
		Temple result = mapper.selectByPrimaryKey(templeId);
		return result;
	}

}
