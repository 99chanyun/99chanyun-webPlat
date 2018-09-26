package com.chanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.MeritsMapper;
import com.chanyun.entity.Merits;
import com.chanyun.service.MeritsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class MeritsServiceImpl implements MeritsService{
	@Autowired
	private MeritsMapper meritsMapper;
	@Override
	public PageInfo<Merits> findByPage(int pageNum, int pageSize,Merits merits) {
		PageHelper.startPage(pageNum,pageSize);
		PageHelper.orderBy("apply_time desc");
		Page<Merits> sqlResult = meritsMapper.selectByPage(merits);
		PageInfo<Merits> result = new PageInfo<Merits>(sqlResult);
		return result;
	}

}
