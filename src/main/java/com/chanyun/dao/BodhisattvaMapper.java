package com.chanyun.dao;

import com.chanyun.entity.Bodhisattva;

public interface BodhisattvaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bodhisattva record);

    int insertSelective(Bodhisattva record);

    Bodhisattva selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bodhisattva record);

    int updateByPrimaryKey(Bodhisattva record);
}