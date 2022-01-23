package com.waysn.modules.blog.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.blog.dto.BlogLineWordDTO;
import com.waysn.modules.blog.entity.BlogLineWordEntity;

import java.util.List;

/**
 * 博客一句话
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-23
 */
public interface BlogLineWordService extends CrudService<BlogLineWordEntity, BlogLineWordDTO> {
    public List<BlogLineWordEntity> getAllWord();
}