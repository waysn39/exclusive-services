/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.commons.dynamic.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author jinyiming waysn39@hotmail.com
 * @since 1.0.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
