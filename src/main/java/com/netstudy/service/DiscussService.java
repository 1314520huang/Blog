package com.netstudy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netstudy.bean.Discuss;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
public interface DiscussService extends IService<Discuss> {

    IPage<Discuss> getPage(Page page, int type);

    boolean save(HttpServletRequest request, Discuss discuss);
}
