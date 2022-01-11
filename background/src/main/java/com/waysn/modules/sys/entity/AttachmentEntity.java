package com.waysn.modules.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 附件管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_attachment")
public class AttachmentEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	* 附件名称
	*/
	private String attachName;
	/**
	* 路径
	*/
	private String attachPath;
	/**
	* 数据长度
	*/
	private Long attachLength;
	/**
	* 后缀
	*/
	private String attachExt;
}