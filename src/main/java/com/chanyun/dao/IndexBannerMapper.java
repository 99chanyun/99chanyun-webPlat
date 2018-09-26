package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.IndexBanner;
import com.github.pagehelper.Page;

public interface IndexBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexBanner record);

    int insertSelective(IndexBanner record);

    IndexBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexBanner record);

    int updateByPrimaryKey(IndexBanner record);
    
    /**
     * 查询首页显示
     * @return
     */
    List<IndexBanner> selectIndexBanner();
    
    /**
     * 分页查询banner列表
     * @param params
     * @return
     */
    Page<IndexBanner> selectIndexBannerByPage(IndexBanner params);
        
}