/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.demo.service;

import com.waysn.comm.page.PageData;
import com.waysn.comm.service.BaseService;
import com.waysn.modules.demo.entity.NewsEntity;
import com.waysn.modules.demo.dto.NewsDTO;

import java.util.Map;

/**
 * 新闻
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface NewsService extends BaseService<NewsEntity> {

    PageData<NewsDTO> page(Map<String, Object> params);

    NewsDTO get(Long id);

    void save(NewsDTO dto);

    void update(NewsDTO dto);
}

