package com.netstudy.controller;


import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.BaseController;
import com.netstudy.common.bean.Remarks;
import com.netstudy.bean.Blog;
import com.netstudy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

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

    @PostMapping("")
    @ResponseBody
    @Remarks("新增博客")
    public AjaxResponse add(Blog blog) {

        blogServiceImpl.save(blog);
        return new AjaxResponse();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @Remarks("获取博客详情")
    public AjaxResponse info(@PathVariable long id) {

        AjaxResponse response = new AjaxResponse();
        Map<String, Object> map = blogServiceImpl.getDetail(id);
        response.setData(map);
        return response;
    }
}
