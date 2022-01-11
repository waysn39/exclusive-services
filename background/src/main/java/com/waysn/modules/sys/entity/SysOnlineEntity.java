/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */
package com.waysn.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.waysn.comm.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 在线用户
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
public class SysOnlineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	* 用户ID
	*/
	private Long userId;
	/**
	* 用户名
	*/
	private String username;
	/**
	* 姓名
	*/
	private String realName;
	/**
	* 登录时间
	*/
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date loginDate;
	/**
	 * 超时时间
	 */
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date ExpireDate;
}