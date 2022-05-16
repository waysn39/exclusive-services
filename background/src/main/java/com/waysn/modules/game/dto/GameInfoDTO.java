package com.waysn.modules.game.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 游戏信息表
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-05-16
*/
@Data
@ApiModel(value = "游戏信息表")
public class GameInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "游戏标题")
    private String gameTitle;
    @ApiModelProperty(value = "自定义标题")
    private String gameCustomTitle;
    @ApiModelProperty(value = "标题关键词")
    private String gameTitleKeyword;
    @ApiModelProperty(value = "游戏版本号")
    private String gameVersion;
    @ApiModelProperty(value = "分类id")
    private Long classifyId;
    @ApiModelProperty(value = "游戏分类名称")
    private String classifyName;
    @ApiModelProperty(value = "游戏平台")
    private Integer gamePlatformType;
    @ApiModelProperty(value = "下载跳转类型")
    private Integer downloadJumpType;
    @ApiModelProperty(value = "游戏下载地址")
    private String gameDownloadUrl;
    @ApiModelProperty(value = "游戏安卓下载地址")
    private String gameDownloadAndroidUrl;
    @ApiModelProperty(value = "游戏苹果下载地址")
    private String gameDownloadIosUrl;
    @ApiModelProperty(value = "游戏下载提示")
    private String gameDownloadInfo;
    @ApiModelProperty(value = "摘要")
    private String gameSummaryn;
    @ApiModelProperty(value = "游戏介绍")
    private String gameInfo;
    @ApiModelProperty(value = "游戏关键词")
    private String gameKeyWord;
    @ApiModelProperty(value = "游戏大小")
    private Double gameSize;
    @ApiModelProperty(value = "游戏缩略图")
    private String gamePicUrl;
    @ApiModelProperty(value = "游戏评分")
    private String gameMark;
    @ApiModelProperty(value = "是否启用")
    private Boolean isUsed;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "更新者")
    private Long updater;
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

}