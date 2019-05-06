package com.netstudy.service;

import com.netstudy.bean.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 用户 - 角色表 服务类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
public interface UserRoleService extends IService<UserRole> {

    Set<String> getPermissions(long userId);
}
