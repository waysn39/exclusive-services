/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.waysn.comm.utils.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * 基类管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@TableName("gen_base_class")
public class BaseClassEntity {
    /**
     * id
     */
    private Long id;
    /**
     * 基类包名
     */
    private String packageName;
    /**
     * 基类编码
     */
    private String code;
    /**
     * 公共字段，多个用英文逗号分隔
     */
    private String fields;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createDate;
}