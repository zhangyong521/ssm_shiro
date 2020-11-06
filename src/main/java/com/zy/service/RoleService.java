package com.zy.service;

import java.util.List;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-05 10:40
 * @PS:
 */
public interface RoleService {
    /**
     * 根据ID查询角色
     * @param userId
     * @return
     */
    List<String> queryRolesByUserId(Integer userId);
}
