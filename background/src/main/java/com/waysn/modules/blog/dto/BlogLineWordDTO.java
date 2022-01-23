package com.waysn.modules.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 博客一句话
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-23
*/
@Data
@ApiModel(value = "博客一句话")
public class BlogLineWordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "一句话")
    private String lineWord;

}