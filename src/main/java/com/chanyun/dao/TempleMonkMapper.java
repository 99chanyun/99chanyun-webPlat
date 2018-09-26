package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.TempleMonk;
import com.github.pagehelper.Page;

public interface TempleMonkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempleMonk record);

    int insertSelective(TempleMonk record);

    TempleMonk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempleMonk record);

    int updateByPrimaryKeyWithBLOBs(TempleMonk record);

    int updateByPrimaryKey(TempleMonk record);
    
    /**
     * 根据条件查询寺庙僧人列表
     * @param templeMonk
     * @return
     */
    List<TempleMonk> selectByParams(TempleMonk templeMonk);
    
    /**
     * 分页查询寺庙僧人列表
     * @param templeMonk
     * @return
     */
    Page<TempleMonk> selectByPage(TempleMonk templeMonk);
}