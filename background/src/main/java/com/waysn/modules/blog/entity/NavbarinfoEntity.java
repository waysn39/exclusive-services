package com.waysn.modules.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 博客导航
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_navbarInfo")
public class NavbarinfoEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	* 节点编码
	*/
	private String navbarCode;
	/**
	* 导航名称
	*/
	private String navbarName;
	/**
	* 连接
	*/
	private String navbarLink;
	/**
	* 图标
	*/
	private String navbarIconClass;
	/**
	* 父节点
	*/
	private String parentCode;
	/**
	* 是否启用
	*/
	private Boolean isUsed;
}