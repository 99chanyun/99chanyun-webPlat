package com.chanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.TempleMonkMapper;
import com.chanyun.entity.TempleMonk;
import com.chanyun.service.TempleMonkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class TempleMonkServiceImpl implements TempleMonkService {
	@Autowired
	private TempleMonkMapper mapper;

	@Override
	public TempleMonk add(TempleMonk templeMonk) {
		int i = mapper.insertSelective(templeMonk);
		if(i>0) return templeMonk;
		return null;
	}

	@Override
	public boolean edit(TempleMonk templeMonk) {
		int i = mapper.updateByPrimaryKeySelective(templeMonk);
		if(i>0) return true;
		return false;
	}

	@Override
	public PageInfo<TempleMonk> queryByPage(int pageNum, int pageSize,
			TempleMonk templeMonk) {
		PageHelper.startPage(pageNum,pageSize);
		PageHelper.orderBy("sort asc,create_time desc");
		Page<TempleMonk> sqlResult = mapper.selectByPage(templeMonk);
		PageInfo<TempleMonk> result = new PageInfo<TempleMonk>(sqlResult);
		return result;
	}

	@Override
	public TempleMonk queryById(int monkId) {
		TempleMonk monk = mapper.selectByPrimaryKey(monkId);
		return monk;
	}

}
