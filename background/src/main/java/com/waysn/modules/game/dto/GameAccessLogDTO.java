package com.waysn.modules.game.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 游戏访问日志表
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-06-30
*/
@Data
@ApiModel(value = "游戏访问日志表")
public class GameAccessLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "更新者")
    private Long updater;
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;
    @ApiModelProperty(value = "游戏id")
    private Long gameId;
    @ApiModelProperty(value = "分类id")
    private Long classifyId;
    @ApiModelProperty(value = "浏览次数")
    private Integer viewCount;
    @ApiModelProperty(value = "下载次数")
    private Integer downloadCount;

}