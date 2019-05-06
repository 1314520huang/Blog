package com.netstudy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netstudy.bean.Discuss;
import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.Remarks;
import com.netstudy.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    private DiscussService discussServiceImpl;

    @GetMapping("/{type}")
    @ResponseBody
    @Remarks("分页获取评论")
    public AjaxResponse list(int pageIndex, int pageCount, @PathVariable int type) {

        AjaxResponse response = new AjaxResponse();
        response.setData(discussServiceImpl.getPage(new Page(pageIndex, pageCount), type));
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Remarks("伪删除评论")
    public AjaxResponse delete(@PathVariable long id) {

        discussServiceImpl.removeById(id);
        return new AjaxResponse();
    }

    @PostMapping("")
    @ResponseBody
    @Remarks("添加新的评论")
    public AjaxResponse add(HttpServletRequest request, Discuss discuss) {

        discussServiceImpl.save(request, discuss);
        return new AjaxResponse();
    }
}
