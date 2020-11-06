package com.zy.mapper;

import com.zy.domain.Permission;

import java.util.List;


/**
 * @author 17616
 * 权限的dao
 */
public interface PermissionMapper {

    int deleteByPrimaryKey(Integer perid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer perid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 根据Id查询权限
     * @param userId
     * @return
     */
    List<Permission> queryPermissionByUserId(Integer userId);

}