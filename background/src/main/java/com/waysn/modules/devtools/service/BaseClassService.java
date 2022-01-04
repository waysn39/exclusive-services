/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.service;


import com.waysn.comm.page.PageData;
import com.waysn.comm.service.BaseService;
import com.waysn.modules.devtools.entity.BaseClassEntity;

import java.util.List;
import java.util.Map;

/**
 * 基类管理
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface BaseClassService extends BaseService<BaseClassEntity> {

    PageData<BaseClassEntity> page(Map<String, Object> params);

    List<BaseClassEntity> list();
}