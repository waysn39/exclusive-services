/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.service;

import com.waysn.comm.page.PageData;
import com.waysn.comm.service.BaseService;
import com.waysn.modules.devtools.entity.DataSourceEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据源管理
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface DataSourceService extends BaseService<DataSourceEntity> {

    PageData<DataSourceEntity> page(Map<String, Object> params);

    List<DataSourceEntity> list();
}