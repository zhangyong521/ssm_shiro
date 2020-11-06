package com.zy.mapper;

import com.zy.domain.User;

/**
 * @author 17616
 * 用户的Dao
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User queryUserByUserName(String username);
}