/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.flow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.waysn.comm.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 模型管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@TableName("ACT_DE_MODEL")
public class FlowModelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String modelKey;
    private String description;
    private String modelComment;
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date created;
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date lastUpdated;
    private String createdBy;
    private String lastUpdatedBy;
    private Integer version;
    private String modelEditorJson;
    private byte[] thumbnail;
    private Integer modelType;
    private String tenantId;

}
