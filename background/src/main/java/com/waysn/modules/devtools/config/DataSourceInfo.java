/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.config;

import com.waysn.modules.devtools.config.query.*;
import com.waysn.modules.devtools.entity.DataSourceEntity;
import com.waysn.modules.devtools.utils.DbType;
import com.waysn.modules.devtools.utils.DbUtils;
import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据源信息
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
public class DataSourceInfo {
    /**
     * 数据源ID
     */
    private Long id;
    /**
     * 数据库类型
     */
    private DbType dbType;
    /**
     * 数据库URL
     */
    private String connUrl;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    private AbstractQuery dbQuery;

    private Connection connection;

    public DataSourceInfo(DataSourceEntity entity) {
        this.id = entity.getId();
        this.dbType = DbType.valueOf(entity.getDbType());
        this.connUrl = entity.getConnUrl();
        this.username = entity.getUsername();
        this.password = entity.getPassword();

        if (dbType == DbType.MySQL) {
            this.dbQuery = new MySqlQuery();
        } else if (dbType == DbType.Oracle) {
            this.dbQuery = new OracleQuery();
        } else if (dbType == DbType.SQLServer) {
            this.dbQuery = new SqlServerQuery();
        } else if (dbType == DbType.PostgreSQL) {
            this.dbQuery = new PostgreSqlQuery();
        }

        try {
            this.connection = DbUtils.getConnection(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DataSourceInfo(Connection connection) throws SQLException {
        this.id = 0L;
        this.dbType = DbType.valueOf(connection.getMetaData().getDatabaseProductName());

        if (dbType == DbType.MySQL) {
            this.dbQuery = new MySqlQuery();
        } else if (dbType == DbType.Oracle) {
            this.dbQuery = new OracleQuery();
        } else if (dbType == DbType.SQLServer) {
            this.dbQuery = new SqlServerQuery();
        } else if (dbType == DbType.PostgreSQL) {
            this.dbQuery = new PostgreSqlQuery();
        }

        this.connection = connection;
    }
}
