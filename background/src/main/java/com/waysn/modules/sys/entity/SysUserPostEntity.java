/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户岗位关系
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@TableName("sys_user_post")
public class SysUserPostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 岗位ID
     */
    private Long postId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private Long creator;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
}