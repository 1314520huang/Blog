package com.netstudy.controller;


import com.forstudy.common.bean.AjaxResponse;
import com.forstudy.common.bean.BaseController;
import com.forstudy.common.bean.Remarks;
import com.netstudy.bean.Blog;
import com.netstudy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 博客表 前端控制器
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {

    @Autowired
    private BlogService blogServiceImpl;

    @GetMapping("")
    @ResponseBody
    @Remarks("获取所有博客列表")
    public AjaxResponse list() {

        AjaxResponse response = new AjaxResponse();
        List<Blog> blogs = blogServiceImpl.list();
        response.setData(blogs);
        return response;
    }
}
