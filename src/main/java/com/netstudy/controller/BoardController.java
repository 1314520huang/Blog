package com.netstudy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netstudy.bean.Board;
import com.netstudy.common.bean.AjaxResponse;
import com.netstudy.common.bean.Remarks;
import com.netstudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 留言板 前端控制器
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardServiceImpl;

    @GetMapping("")
    @ResponseBody
    @Remarks("获取所有留言")
    public AjaxResponse list(int pageIndex, int pageCount) {

        AjaxResponse response = new AjaxResponse();
        response.setData(boardServiceImpl.getPage(new Page(pageIndex, pageCount)));
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Remarks("伪删除留言")
    public AjaxResponse delete(@PathVariable long id) {

        boardServiceImpl.removeById(id);
        return new AjaxResponse();
    }

    @PostMapping("")
    @ResponseBody
    @Remarks("添加新留言")
    public AjaxResponse add(HttpServletRequest request, Board board) {

        boardServiceImpl.save(request, board);
        return new AjaxResponse();
    }
}
