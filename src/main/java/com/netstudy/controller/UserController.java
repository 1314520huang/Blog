package com.netstudy.controller;


import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.BaseController;
import com.netstudy.common.bean.Remarks;
import com.netstudy.common.exception.AIException;
import com.netstudy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/login")
    @ResponseBody
    @Remarks("登录操作")
    public AjaxResponse login(String loginName, String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        subject.login(token);
        return new AjaxResponse();
    }
}
