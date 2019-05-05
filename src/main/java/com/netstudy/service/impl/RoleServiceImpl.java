package com.netstudy.service.impl;

import com.netstudy.bean.Role;
import com.netstudy.dao.RoleMapper;
import com.netstudy.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
