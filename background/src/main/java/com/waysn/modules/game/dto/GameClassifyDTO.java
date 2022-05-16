package com.waysn.modules.game.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.waysn.comm.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 游戏分类
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
@Data
@ApiModel(value = "游戏分类")
public class GameClassifyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "游戏分类名称")
    private String classifyName;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "更新者")
    private Long updater;
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

}