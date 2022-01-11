package com.waysn.modules.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.waysn.comm.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 公众号账号管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mp_account")
public class MpAccountEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;
    /**
     * AppID
     */
    private String appId;
    /**
     * AppSecret
     */
    private String appSecret;
    /**
     * Token
     */
    private String token;
    /**
     * EncodingAESKey
     */
    private String aesKey;
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