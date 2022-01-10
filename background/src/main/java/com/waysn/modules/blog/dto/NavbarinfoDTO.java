package com.waysn.modules.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 博客导航
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-09
*/
@Data
@ApiModel(value = "博客导航")
public class NavbarinfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "节点编码")
    private String navbarCode;
    @ApiModelProperty(value = "导航名称")
    private String navbarName;
    @ApiModelProperty(value = "连接")
    private String navbarLink;
    @ApiModelProperty(value = "图标")
    private String navbarIconClass;
    @ApiModelProperty(value = "父节点")
    private String parentCode;
    @ApiModelProperty(value = "是否启用")
    private Boolean isUsed;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

}