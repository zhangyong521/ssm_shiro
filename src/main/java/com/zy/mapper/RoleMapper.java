package com.zy.mapper;

import com.zy.domain.Role;

import java.util.List;

/**
 * @author 17616
 * 角色的dao
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据ID查询角色
     * @param userId
     * @return
     */
    List<Role> queryRolesByUserId(Integer userId);
}