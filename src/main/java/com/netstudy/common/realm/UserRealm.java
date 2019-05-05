package com.forstudy.common.realm;

import com.netstudy.service.UserRoleService;
import com.netstudy.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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

    /*
        用户权限判断， 同时赋权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        long id = (long)collection.getPrimaryPrincipal();
//        Set<String> permissions = userRoleService.getPermissions(id);
//        info.setStringPermissions(permissions);
        return info;
    }

    /*
        用户身份判断
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        try {


        } catch (Exception e) {


        }
        return info;
    }
}
