package com.netstudy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netstudy.bean.Board;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 留言板 服务类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
public interface BoardService extends IService<Board> {

    IPage getPage(Page page);
}
