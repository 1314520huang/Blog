package com.netstudy.controller;


import com.netstudy.bean.Collect;
import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.Remarks;
import com.netstudy.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectServiceImpl;

    @PostMapping("")
    @ResponseBody
    @Remarks("新增收藏")
    public AjaxResponse add(HttpServletRequest request, Collect collect) {

        collectServiceImpl.addCollect(request, collect);
        return new AjaxResponse();
    }

    @GetMapping("")
    @ResponseBody
    @Remarks("获取登录者的收藏列表")
    public AjaxResponse list(HttpServletRequest request) {

        AjaxResponse response = new AjaxResponse();
        response.setData(collectServiceImpl.myCollect(request));
        return response;
    }
}
