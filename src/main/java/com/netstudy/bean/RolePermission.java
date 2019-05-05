package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色- 权限表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色-权限 主键
     */
    private Long id;

    /**
     * 角色主键
     */
    private Long roleId;

    /**
     * 权限主键
     */
    private Long permissionId;

    /**
     * 创建日期
     */
    private LocalDateTime createDate;


}
