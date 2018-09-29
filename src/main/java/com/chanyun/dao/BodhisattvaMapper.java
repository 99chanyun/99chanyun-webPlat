package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.Bodhisattva;

public interface BodhisattvaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bodhisattva record);

    int insertSelective(Bodhisattva record);

    Bodhisattva selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bodhisattva record);

    int updateByPrimaryKey(Bodhisattva record);
    
    /**
     * 根据条件查询菩萨列表
     * @param params
     * @return
     */
    List<Bodhisattva> queryByParams(Bodhisattva params);
    
}