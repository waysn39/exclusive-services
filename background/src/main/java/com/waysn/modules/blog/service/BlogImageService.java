package com.waysn.modules.blog.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.blog.dto.BlogImageDTO;
import com.waysn.modules.blog.entity.BlogImageEntity;
import com.waysn.modules.blog.enums.BlogImageEnum;

import java.util.List;

/**
 * 博客图片管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-13
 */
public interface BlogImageService extends CrudService<BlogImageEntity, BlogImageDTO> {

    /**
     * 获取图片Path
     *
     * @param type 图片类型
     * @return 图片PATH
     */
    List<String> getImgByType(BlogImageEnum type);


}