package com.netstudy.common.realm;

import com.netstudy.common.bean.Remarks;
import com.netstudy.common.exception.AIException;
import com.netstudy.service.UserRoleService;
import com.netstudy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void setName(String name) {
        super.setName("com.forstudy.common.realm.UserRealm");
    }

    @Override
    public String getName() {

        return "com.netstudy.common.realm.UserRealm";
    }

    @Remarks("用户权限判断， 同时赋权")
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        long id = (long)collection.getPrimaryPrincipal();
        Set<String> permissions = userRoleService.getPermissions(id);
        info.setStringPermissions(permissions);
        return info;
    }

    @Remarks("用户身份判断")
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        SimpleAuthenticationInfo info;
        try {
            String loginName = (String)token.getCredentials();
            String password = (String) token.getPrincipal();
            long userId = userService.login(loginName, password);
            info = new SimpleAuthenticationInfo(userId, password, getName());
        } catch (UnknownAccountException e) {
            throw new AIException("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            throw new AIException("账号或密码不正确");
        }
        return info;
    }
}
