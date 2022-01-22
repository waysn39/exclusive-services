package com.waysn.modules.blog.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.blog.dto.BlogImageDTO;
import com.waysn.modules.blog.entity.BlogImageEntity;

import java.util.List;

/**
 * 博客图片管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-13
 */
public interface BlogImageService extends CrudService<BlogImageEntity, BlogImageDTO> {
    /**
     * 获取背景图Path
     *
     * @return
     */
    List<String> getBackGroundImg();

    /**
     * 获取背景图Path
     *
     * @return
     */
    List<String> getLogoImg();
}