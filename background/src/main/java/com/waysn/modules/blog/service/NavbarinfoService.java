package com.waysn.modules.blog.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.blog.dto.NavbarinfoDTO;
import com.waysn.modules.blog.entity.NavbarinfoEntity;

import java.util.List;

/**
 * 博客导航
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-09
 */
public interface NavbarinfoService extends CrudService<NavbarinfoEntity, NavbarinfoDTO> {
    List<NavbarinfoEntity> getAllNavbarInfo();
}