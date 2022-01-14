package com.waysn.modules.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 博客图片管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_blog_image")
public class BlogImageEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	* 图片类型
	*/
	private Integer imageType;
	/**
	* 图片路径
	*/
	private String imagePath;
}