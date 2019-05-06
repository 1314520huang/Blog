package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 留言板
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Board implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 留言主键
     */
    private Long id;

    /**
     * 留言人主键
     */
    private Long userId;

    /**
     * 留言人姓名
     */
    private String userName;

    /**
     * 评论内容存放在MongoDB当中，通过content_id进行绑定
     */
    private String contentId;

    /**
     * 当前状态 0 删除 1 正常
     */
    @TableLogic
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
