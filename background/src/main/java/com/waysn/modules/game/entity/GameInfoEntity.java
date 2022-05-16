package com.waysn.modules.game.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 游戏信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_game_info")
public class GameInfoEntity {
	private static final long serialVersionUID = 1L;

	/**
	* id
	*/
	@TableId
	private Long id;
	/**
	* 游戏标题
	*/
	private String gameTitle;
	/**
	* 自定义标题
	*/
	private String gameCustomTitle;
	/**
	* 标题关键词
	*/
	private String gameTitleKeyword;
	/**
	* 游戏版本号
	*/
	private String gameVersion;
	/**
	* 分类id
	*/
	private Long classifyId;
	/**
	* 游戏分类名称
	*/
	private String classifyName;
	/**
	* 游戏平台
	*/
	private Integer gamePlatformType;
	/**
	* 下载跳转类型
	*/
	private Integer downloadJumpType;
	/**
	* 游戏下载地址
	*/
	private String gameDownloadUrl;
	/**
	* 游戏安卓下载地址
	*/
	private String gameDownloadAndroidUrl;
	/**
	* 游戏苹果下载地址
	*/
	private String gameDownloadIosUrl;
	/**
	* 游戏下载提示
	*/
	private String gameDownloadInfo;
	/**
	* 摘要
	*/
	private String gameSummaryn;
	/**
	* 游戏介绍
	*/
	private String gameInfo;
	/**
	* 游戏关键词
	*/
	private String gameKeyWord;
	/**
	* 游戏大小
	*/
	private Double gameSize;
	/**
	* 游戏缩略图
	*/
	private String gamePicUrl;
	/**
	* 游戏评分
	*/
	private String gameMark;
	/**
	* 是否启用
	*/
	private Boolean isUsed;
	/**
	* 创建者
	*/
	@TableField(fill = FieldFill.INSERT)
	private Long creator;
	/**
	* 创建时间
	*/
	@TableField(fill = FieldFill.INSERT)
	private Date createDate;
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