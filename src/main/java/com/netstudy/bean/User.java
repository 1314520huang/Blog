package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private Long id;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 加密密码
     */
    private String password;

    /**
     * 加盐参数
     */
    private String salt;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 头像存放在MongoDB当中，通过head_id进行绑定
     */
    private String headId;

    /**
     * 当前状态, 0 冻结 1 正常
     */
    @TableLogic
    private Integer state;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 用户注册日期
     */
    private LocalDateTime createDate;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLogin;


}
