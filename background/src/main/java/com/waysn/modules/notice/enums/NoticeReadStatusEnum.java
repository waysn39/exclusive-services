/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.notice.enums;

/**
 * 通知阅读状态枚举
 *
 * @author Mark sunlightcs@gmail.com
 */
public enum NoticeReadStatusEnum {
    /**
     * 未读
     */
    UNREAD(0),
    /**
     * 已读
     */
    READ(1);

    private int value;

    NoticeReadStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
