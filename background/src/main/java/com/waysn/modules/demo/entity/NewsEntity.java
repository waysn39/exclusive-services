/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.waysn.comm.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 新闻
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_news")
public class NewsEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date pubDate;
    /**
     * 创建者dept_id
     */
    @TableField(fill = FieldFill.INSERT)
    private Long deptId;
    /**
     * 更新者
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updater;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
}