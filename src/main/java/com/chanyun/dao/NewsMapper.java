package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.News;
import com.github.pagehelper.Page;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
    
    /**
     * 查询首页新闻推荐
     * @return
     */
    List<News> selectIndexNews();
    
    /**
     * 分页查询资讯信息
     * @param news
     * @return
     */
    Page<News> selectNewsByPage(News news);
    
    /**
     * 通过条件查询资讯信息
     * @param news
     * @return
     */
    List<News> selectNewsByParams(News news);
    
}