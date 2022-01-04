/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.config.query;


import com.waysn.modules.devtools.utils.DbType;

/**
 * Query
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface AbstractQuery {

    /**
     * 数据库类型
     */
    DbType dbType();

    /**
     * 表信息查询 SQL
     */
    String tablesSql(String tableName);

    /**
     * 表名称
     */
    String tableName();

    /**
     * 表注释
     */
    String tableComment();

    /**
     * 表字段信息查询 SQL
     */
    String tableFieldsSql();

    /**
     * 字段名称
     */
    String fieldName();


    /**
     * 字段类型
     */
    String fieldType();


    /**
     * 字段注释
     */
    String fieldComment();

    /**
     * 主键字段
     */
    String fieldKey();
}
