package com.waysn.modules.game.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 游戏分类
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_game_classify")
public class GameClassifyEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	* 游戏分类名称
	*/
	private String classifyName;
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