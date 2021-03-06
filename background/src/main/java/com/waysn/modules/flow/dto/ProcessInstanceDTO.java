/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.flow.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.waysn.comm.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Jone
 */
@Data
@Api(tags="实例")
public class ProcessInstanceDTO {
    @ApiModelProperty(value = "实例ID")
    private String processInstanceId;

    @ApiModelProperty(value = "流程定义ID")
    private String processDefinitionId;

    @ApiModelProperty(value = "流程定义名称")
    private String processDefinitionName;

    @ApiModelProperty(value = "流程定义KEY")
    private String processDefinitionKey;

    @ApiModelProperty(value = "流程定义版本")
    private Integer processDefinitionVersion;

    @ApiModelProperty(value = "部署ID")
    private String deploymentId;

    @ApiModelProperty(value = "业务唯一KEY")
    private String businessKey;

    @ApiModelProperty(value = "实例名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否结束")
    private boolean isEnded;

    @ApiModelProperty(value = "是否挂起")
    private boolean isSuspended;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date endTime;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date startTime;

    @ApiModelProperty(value = "发起人ID")
    private String createUserId;

    @ApiModelProperty(value = "发起人姓名")
    private String startUserName;

    @ApiModelProperty(value = "当前任务")
    private List<TaskDTO> currentTaskList;

    @ApiModelProperty(value = "任务名称")
    private String taskName;
}
