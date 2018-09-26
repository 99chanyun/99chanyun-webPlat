package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.TempleIntroduceMapper;
import com.chanyun.entity.TempleIntroduce;
import com.chanyun.service.TempleIntroduceService;

@Service
public class TempleIntroduceServiceImpl implements TempleIntroduceService{
	@Autowired
	private TempleIntroduceMapper mapper;
	@Override
	public TempleIntroduce add(TempleIntroduce templeIntroduce) {
		int i = mapper.insertSelective(templeIntroduce);
		if(i>0) return templeIntroduce;
		return null;
	}

	@Override
	public boolean edit(TempleIntroduce templeIntroduce) {
		int i = mapper.updateByPrimaryKeySelective(templeIntroduce);
		if(i>0) return true;
		return false;
	}

	@Override
	public TempleIntroduce queryTempleIntroduceByTempleId(int templeId) {
		TempleIntroduce templeIntroduce = new TempleIntroduce();
		templeIntroduce.setTempleId(templeId);
		List<TempleIntroduce> list = mapper.selectByParams(templeIntroduce);
		if(null != list && list.size()>0)
			templeIntroduce = list.get(0);
		return templeIntroduce;
	}

	@Override
	public TempleIntroduce queryTempleInttroduceById(int templeIntroduceId) {
		TempleIntroduce result = mapper.selectByPrimaryKey(templeIntroduceId);
		return result;
	}

}
