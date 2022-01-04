/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.service;


import com.waysn.comm.service.BaseService;
import com.waysn.modules.devtools.entity.TableFieldEntity;

import java.util.List;

/**
 * 列
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface TableFieldService extends BaseService<TableFieldEntity> {

    List<TableFieldEntity> getByTableName(String tableName);

    void deleteByTableName(String tableName);

    void deleteBatchTableIds(Long[] tableIds);
}