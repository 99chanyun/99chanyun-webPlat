package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.Constants;
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
	@Override
	public Merits queryMeritsByMeritsNumber(String meritsNumber) {
		Merits merits = new Merits();
		merits.setMeritsNumber(meritsNumber);
		List<Merits> resultList = meritsMapper.selectByParams(merits);
		if(null != resultList && resultList.size() > 0) return resultList.get(0);
		return null;
	}
	@Override
	public Merits addMerits(Merits merits) {
		int i = meritsMapper.insertSelective(merits);
		if (i > 0) return merits;
		return null;
	}
	@Override
	public Merits updateStatusMerits(int meritsStatus, int id) {
		Merits params = new Merits();
		params.setMeritsStatus(meritsStatus);
		params.setId(id);
		int i = meritsMapper.updateByPrimaryKeySelective(params);
		if (i > 0) return meritsMapper.selectByPrimaryKey(id);
		return null;
	}
	
	public List<Merits> queryMeritsListForProductPage(){
		List<Merits> result = meritsMapper.selectMeritsListForProductPage();
		return result;
	}
	@Override
	public Merits queryById(int meritsId) {
		Merits merits = meritsMapper.selectByPrimaryKey(meritsId);
		return merits;
	}
	@Override
	public Merits updateMerits(Merits merits) {
		int i = meritsMapper.updateByPrimaryKeySelective(merits);
		if(i > 0) return merits;
		return null;
	}
	@Override
	public PageInfo<Merits> queryMeritsListForUserPage(int pageNum, int pageSize, int userId) {
		PageHelper.startPage(pageNum,pageSize);
		PageHelper.orderBy("apply_time desc");
		Merits params = new Merits();
		params.setUserId(userId);
		Page<Merits> sqlResult = meritsMapper.selectByPage(params);
		PageInfo<Merits> result = new PageInfo<Merits>(sqlResult);
		return result;
	}
	/* (non-Javadoc)
	 * @see com.chanyun.service.MeritsService#queryMeritsIsPayByMeritsNumber(java.lang.String)
	 */
	@Override
	public Merits queryMeritsIsPayByMeritsNumber(String meritsNumber) {
		Merits merits = new Merits();
		merits.setMeritsNumber(meritsNumber);
		merits.setMeritsStatus(Constants.MERITS_STATUS_PAY);
		List<Merits> resultList = meritsMapper.selectByParams(merits);
		if(null != resultList && resultList.size() > 0) return resultList.get(0);
		return null;
	}

}
