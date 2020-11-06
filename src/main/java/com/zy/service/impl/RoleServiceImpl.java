package com.zy.service.impl;

import com.zy.domain.Role;
import com.zy.mapper.RoleMapper;
import com.zy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: &#x5f20;&#x52c7;
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-05 11:09
 * @PS:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<String> queryRolesByUserId(Integer userId) {

        List<Role> list = roleMapper.queryRolesByUserId(userId);
        ArrayList<String> roles = new ArrayList<>();
        for (Role role : list) {
            roles.add(role.getRolename());
        }
        return roles;
    }

}
