package com.netstudy.service.impl;

import com.netstudy.bean.Collect;
import com.netstudy.common.utils.normal.LoginUtils;
import com.netstudy.dao.CollectMapper;
import com.netstudy.service.CollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 收藏表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
@Transactional
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public void addCollect(HttpServletRequest request, Collect collect) {

        collect.setUserId(LoginUtils.getUser(request).getId());
        collectMapper.insert(collect);
    }

    @Override
    public int findIsLikeByUserIdAndBlogId(long userId, long blogId) {

        return collectMapper.findIsLikeByUserIdAndBlogId(userId, blogId);
    }
}
