package com.chanyun.dao;

import com.chanyun.entity.OnlineMessage;

public interface OnlineMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OnlineMessage record);

    int insertSelective(OnlineMessage record);

    OnlineMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlineMessage record);

    int updateByPrimaryKey(OnlineMessage record);
}