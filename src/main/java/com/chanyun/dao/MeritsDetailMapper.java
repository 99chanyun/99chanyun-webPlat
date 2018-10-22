package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.MeritsDetail;

public interface MeritsDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeritsDetail record);

    int insertSelective(MeritsDetail record);

    MeritsDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeritsDetail record);

    int updateByPrimaryKey(MeritsDetail record);
    
    List<MeritsDetail> queryDetailByMeritsId(int meritsId);
}