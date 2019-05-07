package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 类别表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MyType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别主键
     */
    private Long id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 当前状态 0 删除 1 正常
     */
    @TableLogic
    private Integer state;

    /**
     * 所属父类
     */
    private Long pid;


}
