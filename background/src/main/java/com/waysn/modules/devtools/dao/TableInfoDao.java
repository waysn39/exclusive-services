/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waysn.modules.devtools.entity.TableInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 列
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface TableInfoDao extends BaseMapper<TableInfoEntity> {
    TableInfoEntity getByTableName(String tableName);

    void deleteByTableName(String tableName);
}
