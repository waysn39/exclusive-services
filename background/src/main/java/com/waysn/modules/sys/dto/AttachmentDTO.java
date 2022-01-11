package com.waysn.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 附件管理
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-11
*/
@Data
@ApiModel(value = "附件管理")
public class AttachmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "附件名称")
    private String attachName;
    @ApiModelProperty(value = "路径")
    private String attachPath;
    @ApiModelProperty(value = "数据长度")
    private Long attachLength;
    @ApiModelProperty(value = "后缀")
    private String attachExt;

}