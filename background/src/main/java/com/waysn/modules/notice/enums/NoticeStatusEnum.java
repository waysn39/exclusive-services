/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.notice.enums;

/**
 * 通知状态枚举
 *
 * @author jinyiming waysn39@hotmail.com
 */
public enum NoticeStatusEnum {
    /**
     * 草稿
     */
    DRAFT(0),
    /**
     * 发送
     */
    SEND(1);

    private int value;

    NoticeStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
