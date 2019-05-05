package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏主键
     */
    private Long id;

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 博客主键
     */
    private Long blogId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
