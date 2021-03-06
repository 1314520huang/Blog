package com.netstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netstudy.bean.Board;
import com.netstudy.bean.User;
import com.netstudy.common.utils.normal.LoginUtils;
import com.netstudy.dao.BoardMapper;
import com.netstudy.service.BoardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 留言板 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
@Transactional
public class BoardServiceImpl extends ServiceImpl<BoardMapper, Board> implements BoardService {

    @Override
    public IPage getPage(Page page) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        return this.page(page, queryWrapper);
    }

    @Override
    public void save(HttpServletRequest request, Board board) {

        User user = LoginUtils.getUser(request);
        board.setUserId(user.getId()).setUserName(user.getUserName());
        this.save(board);
    }
}
