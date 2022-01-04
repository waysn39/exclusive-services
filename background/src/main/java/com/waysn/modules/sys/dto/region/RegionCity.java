/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */
package com.waysn.modules.sys.dto.region;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 市
 *
 * @author Mark sunlightcs@gmail.com
 */
@ApiModel(value = "市")
@Data
@EqualsAndHashCode(callSuper = true)
public class RegionCity extends Region {
    @ApiModelProperty(value = "区、县列表")
    private List<Region> counties = new ArrayList<>();
}
