package com.netstudy.service.impl;

import com.netstudy.bean.UserRole;
import com.netstudy.dao.UserRoleMapper;
import com.netstudy.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 用户 - 角色表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Set<String> getPermissions(long userId) {

        return userRoleMapper.getPermissions(userId);
    }
}
