package com.waysn.modules.game.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 游戏下载信息表
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-06-30
*/
@Data
@ApiModel(value = "游戏下载信息表")
public class GameDownloadInfoDTO implements Serializable {
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
    @ApiModelProperty(value = "下载链接")
    private String gameDownloadUrl;
    @ApiModelProperty(value = "安卓链接")
    private String gameDownloadAndroidUrl;
    @ApiModelProperty(value = "ios链接")
    private String gameDownloadIosUrl;
    @ApiModelProperty(value = "下载提示")
    private String gameDownloadTip;

}