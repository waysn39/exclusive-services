package com.waysn.modules.game.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 游戏基础信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_game_base_info")
public class GameBaseInfoEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

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