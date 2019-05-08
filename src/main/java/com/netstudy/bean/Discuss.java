package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Discuss implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论主键
     */
    private Long id;

    /**
     * 评论人主键
     */
    private Long userId;

    /**
     * 评论人名字
     */
    private String userName;

    /**
     * 所属博客
     */
    private Long blogId;

    /**
     * 评论内容存放在MongoDB当中，通过content_id进行绑定
     */
    private String contentId;

    /**
     * 评论时间
     */
    private LocalDateTime createTime;

    /**
     * 当前状态 0 删除 1 正常
     */
    private Integer state;

    /**
     * 评论内容
     */
    private String content;


}
