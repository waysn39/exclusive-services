/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.utils;

/**
 * 数据库类型
 *
 * @author jinyiming waysn39@hotmail.com
 */
public enum DbType {
    /**
     * 支持MySQL、Oracle、SQLServer、PostgreSQL
     */
    MySQL("com.mysql.cj.jdbc.Driver"),
    Oracle("oracle.jdbc.driver.OracleDriver"),
    SQLServer("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    PostgreSQL("org.postgresql.Driver");

    private final String driverClass;

    DbType(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDriverClass() {
        return driverClass;
    }
}