package com.netstudy.common.utils.normal;

import com.netstudy.bean.User;

import javax.servlet.http.HttpServletRequest;

public class LoginUtils {

    public static User getUser(HttpServletRequest request) {

        return (User)request.getSession().getAttribute("usr-login-success");
    }

    public static void save(HttpServletRequest request, User user) {

        request.getSession().setAttribute("usr-login-success", user);
    }
}
