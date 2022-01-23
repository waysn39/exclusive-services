package com.waysn.modules.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import com.waysn.comm.entity.BaseEntity;

/**
 * 博客一句话
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-23
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_blog_line_word")
public class BlogLineWordEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	* 一句话
	*/
	private String lineWord;
}