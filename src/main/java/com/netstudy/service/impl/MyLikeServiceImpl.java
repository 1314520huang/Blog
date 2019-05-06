package com.netstudy.service.impl;

import com.netstudy.bean.MyLike;
import com.netstudy.dao.MyLikeMapper;
import com.netstudy.service.MyLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 喜爱表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
public class MyLikeServiceImpl extends ServiceImpl<MyLikeMapper, MyLike> implements MyLikeService {

    @Autowired
    private MyLikeMapper myLikeMapper;

    @Override
    public int getCountForLike(long blogId) {

        return myLikeMapper.getCountForLike(blogId);
    }

    @Override
    public int getCountForNotLike(long blogId) {

        return myLikeMapper.getCountForNotLike(blogId);
    }
}
