package com.netstudy.controller;


import com.netstudy.bean.MyType;
import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.Remarks;
import com.netstudy.service.MyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 类别表 前端控制器
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/myType")
public class MyTypeController {

    @Autowired
    private MyTypeService myTypeServiceImpl;

    @PostMapping("")
    @ResponseBody
    @Remarks("新增类别")
    public AjaxResponse save(MyType myType) {

        myTypeServiceImpl.saveOrUpdate(myType);
        return new AjaxResponse();
    }

    @GetMapping("")
    @ResponseBody
    @Remarks("获取所有类别")
    public AjaxResponse list() {

        AjaxResponse response = new AjaxResponse();
        response.setData(myTypeServiceImpl.list());
        return response;
    }
}
