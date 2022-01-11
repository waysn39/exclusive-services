/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.sys.dto.region;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 地区管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@ApiModel(value = "地区管理")
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地区ID")
    private Long id;

    @JsonIgnore
    private Long pid;

    @ApiModelProperty(value = "名称")
    private String name;
}
