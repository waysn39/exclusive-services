/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.service;

import com.waysn.modules.devtools.config.DataSourceInfo;
import com.waysn.modules.devtools.entity.MenuEntity;
import com.waysn.modules.devtools.entity.TableFieldEntity;
import com.waysn.modules.devtools.entity.TableInfoEntity;

import java.util.List;

/**
 * 代码生成
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface GeneratorService {

    DataSourceInfo getDataSourceInfo(Long datasourceId);

    void datasourceTable(TableInfoEntity tableInfo);

    void updateTableField(Long tableId, List<TableFieldEntity> tableFieldList);

    void generatorCode(TableInfoEntity tableInfo);

    void generatorMenu(MenuEntity menu);
}
