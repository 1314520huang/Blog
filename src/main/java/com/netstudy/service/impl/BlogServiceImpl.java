package com.netstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netstudy.bean.Blog;
import com.netstudy.bean.User;
import com.netstudy.common.bean.Remarks;
import com.netstudy.common.utils.normal.LoginUtils;
import com.netstudy.dao.BlogMapper;
import com.netstudy.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netstudy.service.CollectService;
import com.netstudy.service.MyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private MyLikeService myLikeServiceImpl;
    @Autowired
    private CollectService collectServiceImpl;

    @Remarks("如果type = 1， 代表查询的是自己所发布的博客")
    @Override
    public List<Blog> list(HttpServletRequest request, int type) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        if(type == 1)
            queryWrapper.eq("user_id", LoginUtils.getUser(request).getId());
        return this.list(queryWrapper);
    }

    @Override
    public boolean save(HttpServletRequest request, Blog blog) {

        User user = LoginUtils.getUser(request);
        blog.setUserId(user.getId()).setUserName(user.getUserName());
        return super.save(blog);
    }

    @Override
    public Map<String, Object> getDetail(long id) {

        Map<String, Object> map = new HashMap<>();
        map.put("blog", super.getById(id));
        map.put("likeSum", myLikeServiceImpl.getCountForLike(id));
        map.put("notLikeSum", myLikeServiceImpl.getCountForNotLike(id));
        map.put("isCollect", collectServiceImpl.findIsLikeByUserIdAndBlogId(12L, id));
        return map;
    }
}
