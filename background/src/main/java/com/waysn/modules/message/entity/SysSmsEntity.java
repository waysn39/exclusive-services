/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.waysn.comm.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 短信
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_sms")
public class SysSmsEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 短信编码
     */
    private String smsCode;
    /**
     * 平台类型
     */
    private Integer platform;
    /**
     * 短信配置
     */
    private String smsConfig;
    /**
     * 备注
     */
    private String remark;
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