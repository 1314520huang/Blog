package com.netstudy.controller;


import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.BaseController;
import com.netstudy.common.bean.Remarks;
import com.netstudy.bean.Blog;
import com.netstudy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/{type}")
    @ResponseBody
    @Remarks("获取所有博客列表， type = 1 代表获取自己的博客")
    public AjaxResponse list(HttpServletRequest request, @PathVariable int type) {

        AjaxResponse response = new AjaxResponse();
        response.setData(blogServiceImpl.list(request, type));
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
        response.setData(blogServiceImpl.getDetail(id));
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Remarks("伪删除博客")
    public AjaxResponse delete(@PathVariable long id) {

        blogServiceImpl.removeById(id);
        return new AjaxResponse();
    }
}
