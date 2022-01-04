/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.service;


import com.waysn.comm.page.PageData;
import com.waysn.comm.service.BaseService;
import com.waysn.modules.devtools.entity.TemplateEntity;

import java.util.List;
import java.util.Map;

/**
 * 模板管理
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface TemplateService extends BaseService<TemplateEntity> {

    PageData<TemplateEntity> page(Map<String, Object> params);

    List<TemplateEntity> list();

    void updateStatusBatch(Long[] ids, int status);

}