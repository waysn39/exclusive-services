/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.sys.enums;

/**
 * 叶子节点枚举
 *
 * @author jinyiming waysn39@hotmail.com
 */
public enum RegionLeafEnum {
    YES(1),
    NO(0);

    private int value;

    RegionLeafEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
