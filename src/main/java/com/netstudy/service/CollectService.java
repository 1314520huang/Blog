package com.netstudy.service;

import com.netstudy.bean.Collect;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 收藏表 服务类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
public interface CollectService extends IService<Collect> {

    void addCollect(HttpServletRequest request, Collect collect);

    int findIsLikeByUserIdAndBlogId(long userId, long blogId);
}
