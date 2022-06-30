package com.waysn.modules.game.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 游戏访问日志表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_game_access_log")
public class GameAccessLogEntity extends BaseEntity {
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
	* 分类id
	*/
	private Long classifyId;
	/**
	* 浏览次数
	*/
	private Integer viewCount;
	/**
	* 下载次数
	*/
	private Integer downloadCount;
}