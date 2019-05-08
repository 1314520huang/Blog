package com.netstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.ImmutableMap;
import com.netstudy.bean.Blog;
import com.netstudy.bean.User;
import com.netstudy.common.bean.Remarks;
import com.netstudy.common.utils.normal.LoginUtils;
import com.netstudy.dao.BlogMapper;
import com.netstudy.dto.BlogDto;
import com.netstudy.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netstudy.service.CollectService;
import com.netstudy.service.MongoDBService;
import com.netstudy.service.MyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
@Transactional
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private MyLikeService myLikeServiceImpl;
    @Autowired
    private CollectService collectServiceImpl;
    @Autowired
    private MongoDBService mongoDBServiceImpl;

    @Remarks("如果type = 1， 代表查询的是自己所发布的博客")
    @Override
    public List<Blog> list(HttpServletRequest request, int type) {

        QueryWrapper queryWrapper = getWholeQw(request, type);
        return this.list(queryWrapper);
    }

    @Override
    public boolean save(HttpServletRequest request, BlogDto dto) {

        User user = LoginUtils.getUser(request);
        String contentId = mongoDBServiceImpl.saveBlog("blog", dto);
        Blog blog = new Blog();
        blog.setContentId(contentId).setTitle(dto.getTitle()); // .setUserId(user.getId()).setUserName(user.getUserName());
        return super.save(blog);
    }

    @Override
    public Map<String, Object> getDetail(long id) {

        Blog blog = super.getById(id);
        Map<String, Object> map = ImmutableMap.of("blog", blog, "likeSum", myLikeServiceImpl.getCountForLike(id), "notLikeSum", myLikeServiceImpl.getCountForNotLike(id),
            "isCollect", collectServiceImpl.findIsLikeByUserIdAndBlogId(12L, id), "content", mongoDBServiceImpl.getContent("blog", blog.getContentId()));
        return map;
    }

    @Override
    public List<Blog> search(Blog blog) {

        QueryWrapper<Blog> queryWrapper = new QueryWrapper();
        queryWrapper.like("title", blog.getTitle()).eq("state", 1).orderByDesc("create_time");
        return this.list(queryWrapper);
    }

    @Override
    public IPage<Blog> getPage(Page page, HttpServletRequest request, int type) {

        QueryWrapper queryWrapper = getWholeQw(request, type);
        return this.page(page, queryWrapper);
    }

    private static QueryWrapper getWholeQw(HttpServletRequest request, int type) {

        QueryWrapper<Blog> queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        if(type == 1)
            queryWrapper.eq("user_id", LoginUtils.getUser(request).getId());
        return queryWrapper;
    }
}
