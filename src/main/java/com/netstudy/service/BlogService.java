package com.netstudy.service;

import com.netstudy.bean.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客表 服务类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
public interface BlogService extends IService<Blog> {

    Map<String, Object> getDetail(long id);

    boolean save(HttpServletRequest request, Blog blog);

    List<Blog> list(HttpServletRequest request, int type);
}
