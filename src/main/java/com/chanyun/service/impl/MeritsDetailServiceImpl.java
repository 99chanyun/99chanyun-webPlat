package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.MeritsDetailMapper;
import com.chanyun.entity.MeritsDetail;
import com.chanyun.service.MeritsDetailService;

@Service
public class MeritsDetailServiceImpl implements MeritsDetailService {
	@Autowired
	private MeritsDetailMapper mapper;
	
	@Override
	public MeritsDetail queryMeritsDetailByMeritsId(int meritsId) {
		List<MeritsDetail> list = mapper.queryDetailByMeritsId(meritsId);
		if(null != list && list.size() > 0) return list.get(0);
		return null;
	}

	@Override
	public MeritsDetail updateOrInsertMertsDetail(MeritsDetail meritsDetail) {
		// TODO Auto-generated method stub
		List<MeritsDetail> list = mapper.queryDetailByMeritsId(meritsDetail.getMeritsId());
		if(null != list && list.size() > 0){ // 详情表中已经订单数据，则更新数据
			meritsDetail.setId(list.get(0).getId());
			int i = mapper.updateByPrimaryKeySelective(meritsDetail);
			if(i > 0) return meritsDetail;
		}else{  //详情表中还没有订单数据，更新详情数据
			int i = mapper.insertSelective(meritsDetail);
			if(i > 0) return meritsDetail;
		}
		return null;
	}

	@Override
	public MeritsDetail insertMeritsDetail(MeritsDetail meritsDetail) {
		int i = mapper.insertSelective(meritsDetail);
		if(i > 0) return meritsDetail;
		return null;
	}

}
