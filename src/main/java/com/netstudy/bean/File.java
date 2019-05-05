package com.netstudy.bean;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件存储表
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件主键
     */
    private Long id;

    /**
     * 上传人主键
     */
    private Long uploadId;

    /**
     * 上传人姓名
     */
    private String uploadName;

    /**
     * 评论内容存放在MongoDB当中，通过file_id进行绑定
     */
    private String fileId;

    /**
     * 当前状态 0 删除 1 正常
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
