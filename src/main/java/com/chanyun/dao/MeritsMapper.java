package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.Merits;
import com.github.pagehelper.Page;

public interface MeritsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merits record);

    int insertSelective(Merits record);

    Merits selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merits record);

    int updateByPrimaryKey(Merits record);
    
    /**
     * 分页查询
     * @param merits
     * @return
     */
    Page<Merits> selectByPage(Merits merits);
    
    /**
     * 条件查询订单列表
     * @param merits
     * @return
     */
    List<Merits> selectByParams(Merits merits);
    
    
}