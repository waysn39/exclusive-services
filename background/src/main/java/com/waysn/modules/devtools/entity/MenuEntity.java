/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.devtools.entity;

import lombok.Data;

/**
 * 创建菜单
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
public class MenuEntity {
    private Long pid;
    private String name;
    private String icon;
    private String moduleName;
    private String className;

}
