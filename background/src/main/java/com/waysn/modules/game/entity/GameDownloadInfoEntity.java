package com.waysn.modules.game.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 游戏下载信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_game_download_info")
public class GameDownloadInfoEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

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
	/**
	* 游戏id
	*/
	private Long gameId;
	/**
	* 下载链接
	*/
	private String gameDownloadUrl;
	/**
	* 安卓链接
	*/
	private String gameDownloadAndroidUrl;
	/**
	* ios链接
	*/
	private String gameDownloadIosUrl;
	/**
	* 下载提示
	*/
	private String gameDownloadTip;
}