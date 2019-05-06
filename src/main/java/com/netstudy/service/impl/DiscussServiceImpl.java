package com.netstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netstudy.bean.Discuss;
import com.netstudy.common.bean.Remarks;
import com.netstudy.common.utils.normal.LoginUtils;
import com.netstudy.dao.DiscussMapper;
import com.netstudy.service.DiscussService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
public class DiscussServiceImpl extends ServiceImpl<DiscussMapper, Discuss> implements DiscussService {

    @Remarks("type == 1, 只显示伪删除的评论")
    @Override
    public IPage<Discuss> getPage(Page page, int type) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        if(type == 1)
            queryWrapper.eq("state", 1);
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean save(HttpServletRequest request, Discuss discuss) {

        discuss.setUserId(LoginUtils.getUser(request).getId()).setUserName(LoginUtils.getUser(request).getUserName());
        return super.save(discuss);
    }
}
