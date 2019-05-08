package com.netstudy.controller;


import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.BaseController;
import com.netstudy.common.bean.Remarks;
import com.netstudy.bean.Blog;
import com.netstudy.dto.BlogDto;
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

    @GetMapping("")
    @ResponseBody
    @Remarks("获取所有博客列表， type = 1 代表获取自己的博客")
    public AjaxResponse list(HttpServletRequest request) {

        AjaxResponse response = new AjaxResponse();
        int type= Integer.parseInt(request.getParameter("type"));
        response.setData(blogServiceImpl.list(request, type));
        return response;
    }

    @PostMapping("")
    @ResponseBody
    @Remarks("新增博客")
    public AjaxResponse add(HttpServletRequest request, BlogDto dto) {

        blogServiceImpl.save(request, dto);
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

    @GetMapping("/search")
    @ResponseBody
    @Remarks("查找博客")
    public AjaxResponse search(Blog blog) {

        AjaxResponse response = new AjaxResponse();
        response.setData(blogServiceImpl.search(blog));
        return response;
    }
}
