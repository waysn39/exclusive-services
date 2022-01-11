package com.waysn.modules.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.waysn.comm.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Excel导入演示
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@ApiModel(value = "Excel导入演示")
public class ExcelDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "学生姓名")
    private String realName;
    @ApiModelProperty(value = "身份证")
    private String identity;
    @ApiModelProperty(value = "家庭地址")
    private String address;
    @ApiModelProperty(value = "入学日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;
    @ApiModelProperty(value = "班级名称")
    private String className;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createDate;

}