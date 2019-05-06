package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客主键
     */
    private Long id;

    /**
     * 创建人主键
     */
    private Long userId;

    /**
     * 创建人名称
     */
    private String userName;

    /**
     * 所属类型主键
     */
    private Long typeId;

    /**
     * 所属分类名称
     */
    private String typeName;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容存放在MongoDB当中，通过content_id进行绑定
     */
    private String contentId;

    /**
     * 文章创建时间
     */
    private LocalDateTime createTime;

    /**
     * 文章状态 0 草稿 -1 删除 1 发布
     */
    @TableLogic
    private Integer state;


}
