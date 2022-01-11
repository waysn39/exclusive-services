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
import com.waysn.modules.devtools.dao.FieldTypeDao;
import com.waysn.modules.devtools.entity.FieldTypeEntity;
import com.waysn.modules.devtools.service.FieldTypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 字段类型管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Service
public class FieldTypeServiceImpl extends BaseServiceImpl<FieldTypeDao, FieldTypeEntity> implements FieldTypeService {

    @Override
    public PageData<FieldTypeEntity> page(Map<String, Object> params) {
        IPage<FieldTypeEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );
        return new PageData<>(page.getRecords(), page.getTotal());
    }

    @Override
    public Map<String, FieldTypeEntity> getMap() {
        List<FieldTypeEntity> list = baseDao.selectList(null);
        Map<String, FieldTypeEntity> map = new LinkedHashMap<>(list.size());
        for (FieldTypeEntity entity : list) {
            map.put(entity.getColumnType().toLowerCase(), entity);
        }
        return map;
    }

    private QueryWrapper<FieldTypeEntity> getWrapper(Map<String, Object> params) {
        String attrType = (String) params.get("attrType");
        String columnType = (String) params.get("columnType");

        QueryWrapper<FieldTypeEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotEmpty(attrType), "attr_type", attrType);
        wrapper.like(StringUtils.isNotEmpty(columnType), "column_type", columnType);

        return wrapper;
    }

    @Override
    public Set<String> getPackageListByTableId(Long tableId) {
        return baseDao.getPackageListByTableId(tableId);
    }

    @Override
    public Set<String> list() {
        return baseDao.list();
    }

}