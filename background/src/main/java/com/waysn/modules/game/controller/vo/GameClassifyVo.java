package com.waysn.modules.game.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: jinyiming
 * @Date: 2022/5/23
 **/
@Data
public class GameClassifyVo {
    /**
     * 游戏分类ID
     */
    @ApiModelProperty(value = "游戏分类id")
    private Long id;
    /**
     * 游戏分类名称
     */
    @ApiModelProperty(value = "游戏分类名称")
    private String classifyName;
}
