package com.netstudy.dao;

import com.netstudy.bean.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收藏表 Mapper 接口
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
public interface CollectMapper extends BaseMapper<Collect> {

    int findIsLikeByUserIdAndBlogId(@Param("userId") long userId, @Param("blogId") long blogId);

    List<Map<String, Object>> myCollect(long userId);
}
