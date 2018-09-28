package com.chanyun.dao;

import com.chanyun.entity.MeritsProduct;

public interface MeritsProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeritsProduct record);

    int insertSelective(MeritsProduct record);

    MeritsProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeritsProduct record);

    int updateByPrimaryKey(MeritsProduct record);
}