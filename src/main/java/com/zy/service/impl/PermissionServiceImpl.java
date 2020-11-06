package com.zy.service.impl;

import com.zy.domain.Permission;
import com.zy.mapper.PermissionMapper;
import com.zy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-05 11:09
 * @PS:
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<String> queryPermissionByUserId(Integer userId) {
        List<Permission> list = permissionMapper.queryPermissionByUserId(userId);
        List<String> permissions = new ArrayList<>();
        for (Permission permission : list) {
            permissions.add(permission.getPercode());
        }
        return permissions;
    }

}
