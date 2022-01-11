/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.devtools.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 代码生成参数配置
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
public class GenParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private String packageName;
    private String version;
    private String author;
    private String email;
    private String backendPath;
    private String frontendPath;
}
