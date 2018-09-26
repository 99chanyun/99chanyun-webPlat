package com.chanyun.dao;


import java.util.List;

import com.chanyun.entity.TempleIntroduce;

public interface TempleIntroduceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempleIntroduce record);

    int insertSelective(TempleIntroduce record);

    TempleIntroduce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempleIntroduce record);

    int updateByPrimaryKeyWithBLOBs(TempleIntroduce record);

    int updateByPrimaryKey(TempleIntroduce record);
    
    /**
     * 根据条件查询寺庙简介
     * @param templeIntroduce
     * @return
     */
    List<TempleIntroduce> selectByParams(TempleIntroduce templeIntroduce);
}