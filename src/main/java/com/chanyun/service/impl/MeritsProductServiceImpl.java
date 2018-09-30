package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.MeritsProductMapper;
import com.chanyun.entity.MeritsProduct;
import com.chanyun.service.MeritsProductService;

@Service
public class MeritsProductServiceImpl implements MeritsProductService {
	@Autowired
	private MeritsProductMapper mapper;
	
	@Override
	public List<MeritsProduct> queryMeritsByTempleIdAndType(int meritsType,
			int templeId) {
		MeritsProduct params = new MeritsProduct();
		params.setMeritsType(meritsType);
		params.setTempleId(templeId);
		List<MeritsProduct> result = mapper.queryByParams(params);
		return result;
	}

	@Override
	public MeritsProduct queryById(int id) {
		MeritsProduct result = mapper.selectByPrimaryKey(id);
		return result;
	}

}
