package com.chanyun.dao;

import java.util.List;
import java.util.Map;

import com.chanyun.entity.User;
import com.github.pagehelper.Page;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    
    /**
     * 分页查询用户资料
     * @param params
     * @return
     */
    Page<User> selectByPage(Map params);
    
    /**
     * 条件查询用户信息
     * @param user
     * @return
     */
    List<User> selectByParams(User user);
    
    /**
     * 查询用户功德榜
     * @return
     */
    List<User> selectByMerits();
    
    /**
     * 
     * @Title: selectCountByParames   
     * @Description: 冥等查询用户数据
     * @param: @param user
     * @param: @return      
     * @return: int      
     * @throws
     */
    int selectCountByParames(User user);
    
}