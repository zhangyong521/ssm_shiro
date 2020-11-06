package com.zy.realm;

import com.zy.domain.User;
import com.zy.service.PermissionService;
import com.zy.service.RoleService;
import com.zy.service.UserService;
import com.zy.utils.ActivierUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-05 10:10
 * @PS:
 *  自定义realm的实现AuthorizingRealm    该realm类提供了两个方法
 *  doGetAuthorizationInfo    获取认证信息
 *  doGetAuthenticationInfo    获取权限信息
 *
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;


    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        // 根据用户名查询用户
        User user = this.userService.queryUserByUserName(username);
        if (null != user) {
            //查询角色
            List<String> roles = this.roleService.queryRolesByUserId(user.getUserid());
            //查询权限
            List<String> permissions = this.permissionService.queryPermissionByUserId(user.getUserid());
            //构造ActiverUser
            ActivierUser activierUser = new ActivierUser(user, roles, permissions);
            //创建盐
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername() + user.getAddress());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activierUser, user.getUserpwd(), credentialsSalt, this.getName());

            return info;
        } else {
            return null;
        }
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ActivierUser activierUser = (ActivierUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<String> roles = activierUser.getRoles();
        List<String> permissions = activierUser.getPermissions();
        if (null != roles && roles.size() > 0) {
            info.addRoles(roles);
        }
        if (null != permissions && permissions.size() > 0) {
            info.addStringPermissions(permissions);
        }
        return info;
    }

}