package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键
     */
    private Long id;

    /**
     * 角色名称
     */
    private String value;

    /**
     * 是否被激活状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;


}
