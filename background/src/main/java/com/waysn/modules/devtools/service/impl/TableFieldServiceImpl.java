/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.service.impl;

import com.waysn.comm.service.impl.BaseServiceImpl;
import com.waysn.modules.devtools.service.TableFieldService;
import com.waysn.modules.devtools.dao.TableFieldDao;
import com.waysn.modules.devtools.entity.TableFieldEntity;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 表
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class TableFieldServiceImpl extends BaseServiceImpl<TableFieldDao, TableFieldEntity> implements TableFieldService {

    @Override
    public List<TableFieldEntity> getByTableName(String tableName) {
        return baseDao.getByTableName(tableName);
    }

    @Override
    public void deleteByTableName(String tableName) {
        baseDao.deleteByTableName(tableName);
    }

    @Override
    public void deleteBatchTableIds(Long[] tableIds) {
        baseDao.deleteBatchTableIds(tableIds);
    }

}