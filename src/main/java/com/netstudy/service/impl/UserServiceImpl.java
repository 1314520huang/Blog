package com.netstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netstudy.bean.User;
import com.netstudy.common.bean.Remarks;
import com.netstudy.common.utils.normal.DateUtil;
import com.netstudy.common.utils.normal.LoginUtils;
import com.netstudy.common.utils.normal.PasswordUtil;
import com.netstudy.common.utils.normal.StringUtil;
import com.netstudy.dao.UserMapper;
import com.netstudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpServletRequest request;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public long login(String loginName, String password) {

        User user = isExistsUser(loginName);
        if (user == null) {
            logger.error("账号不存在");
            throw new UnknownAccountException();
        }
        else {
            if (!isRightUserAndPassword(user, password)) {
                logger.warn("账号密码不正确");
                throw new IncorrectCredentialsException();
            }
            else {
                LoginUtils.save(request, user);
                logger.info(user.getUserName() + ": 登录成功 - " + DateUtil.getNowTime());
                return user.getId();
            }
        }
    }

    @Remarks("判断当前这个用户是否存在")
    private User isExistsUser(String loginName) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", loginName);
        return userMapper.selectOne(queryWrapper);
    }

    @Remarks("判断账号密码是否匹配")
    private boolean isRightUserAndPassword(User user, String password) {

        String pass = PasswordUtil.encode(password, user.getSalt());
        return StringUtil.isSame(user.getPassword(), pass);
    }
}
