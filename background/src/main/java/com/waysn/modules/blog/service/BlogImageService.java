package com.waysn.modules.blog.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.blog.dto.BlogImageDTO;
import com.waysn.modules.blog.entity.BlogImageEntity;

/**
 * 博客图片管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-13
 */
public interface BlogImageService extends CrudService<BlogImageEntity, BlogImageDTO> {
}