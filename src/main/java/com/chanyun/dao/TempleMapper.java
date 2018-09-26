package com.chanyun.dao;

import com.chanyun.entity.Temple;
import com.github.pagehelper.Page;

public interface TempleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Temple record);

    int insertSelective(Temple record);

    Temple selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Temple record);

    int updateByPrimaryKey(Temple record);
    
    /**
     * 分页查询寺庙列表
     * @param temple
     * @return
     */
    Page<Temple> selectByPage(Temple temple);
}