/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.waysn.comm.utils.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * 字段类型管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@TableName("gen_field_type")
public class FieldTypeEntity {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 字段类型
     */
    private String columnType;
    /**
     * 属性类型
     */
    private String attrType;
    /**
     * 属性包名
     */
    private String packageName;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createDate;
}