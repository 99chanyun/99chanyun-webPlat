package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.IndexBannerMapper;
import com.chanyun.entity.IndexBanner;
import com.chanyun.service.IndexBannerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class IndexBannerServiceImpl implements IndexBannerService {
	@Autowired
	private IndexBannerMapper mapper;
	
	@Override
	public List<IndexBanner> queryIndexBannerList() {
		List<IndexBanner> result = mapper.selectIndexBanner();
		return result;
	}

	@Override
	public IndexBanner add(IndexBanner indexBanner) {
		int i = mapper.insertSelective(indexBanner);
		if(i>0) return indexBanner;
		return null;
	}

	@Override
	public boolean edit(IndexBanner indexBanner) {
		int i = mapper.updateByPrimaryKeySelective(indexBanner);
		if(i>0) return true;
		return false;
	}

	@Override
	public IndexBanner queryIndexBannerById(int bannerId) {
		IndexBanner result = mapper.selectByPrimaryKey(bannerId);
		return result;
	}

	@Override
	public PageInfo<IndexBanner> queryIndexBannerByPage(int pageNum,
			int pageSize, IndexBanner indexBanner) {
		PageHelper.startPage(pageNum, pageSize);
		PageHelper.orderBy("create_time desc");
		Page<IndexBanner> sqlResult = mapper.selectIndexBannerByPage(indexBanner);
		PageInfo<IndexBanner> result =  new PageInfo<IndexBanner>(sqlResult);
		return result;
	}

}
