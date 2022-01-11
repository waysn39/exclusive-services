/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.service.impl.BaseServiceImpl;
import com.waysn.modules.devtools.dao.TableInfoDao;
import com.waysn.modules.devtools.entity.TableInfoEntity;
import com.waysn.modules.devtools.service.TableFieldService;
import com.waysn.modules.devtools.service.TableInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;


/**
 * 表
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Service
public class TableInfoServiceImpl extends BaseServiceImpl<TableInfoDao, TableInfoEntity> implements TableInfoService {
    @Autowired
    private TableFieldService tableFieldService;

    @Override
    public PageData<TableInfoEntity> page(Map<String, Object> params) {
        IPage<TableInfoEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );
        return new PageData<>(page.getRecords(), page.getTotal());
    }

    private QueryWrapper<TableInfoEntity> getWrapper(Map<String, Object> params) {
        String tableName = (String) params.get("tableName");

        QueryWrapper<TableInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotEmpty(tableName), "table_name", tableName);

        return wrapper;
    }

    @Override
    public TableInfoEntity getByTableName(String tableName) {
        return baseDao.getByTableName(tableName);
    }

    @Override
    public void deleteByTableName(String tableName) {
        baseDao.deleteByTableName(tableName);
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        //删除表
        super.deleteBatchIds(Arrays.asList(ids));

        //删除列
        tableFieldService.deleteBatchTableIds(ids);
    }
}