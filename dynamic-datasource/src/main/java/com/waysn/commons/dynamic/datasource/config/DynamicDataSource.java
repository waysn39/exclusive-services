/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.commons.dynamic.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源
 *
 * @author jinyiming waysn39@hotmail.com
 * @since 1.0.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicContextHolder.peek();
    }

}
