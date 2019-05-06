package com.netstudy.dao;

import com.netstudy.bean.MyLike;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 喜爱表 Mapper 接口
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
public interface MyLikeMapper extends BaseMapper<MyLike> {

    int getCountForLike(long blogId);

    int getCountForNotLike(long blogId);
}
