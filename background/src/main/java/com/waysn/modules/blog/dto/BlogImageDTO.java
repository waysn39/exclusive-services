package com.waysn.modules.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 博客图片管理
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-13
*/
@Data
@ApiModel(value = "博客图片管理")
public class BlogImageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "图片类型")
    private Integer imageType;
    @ApiModelProperty(value = "图片路径")
    private String imagePath;

}