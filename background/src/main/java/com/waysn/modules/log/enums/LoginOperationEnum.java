/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.log.enums;

/**
 * 登录操作枚举
 *
 * @author jinyiming waysn39@hotmail.com
 * @since 1.0.0
 */
public enum LoginOperationEnum {
    /**
     * 用户登录
     */
    LOGIN(0),
    /**
     * 用户退出
     */
    LOGOUT(1);

    private int value;

    LoginOperationEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}