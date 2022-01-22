package com.waysn.modules.blog.enums;

/**
 * @author waysn
 */

public enum BlogImageEnum {
    /**
     * LOGO
     */
    LOGO(0),
    /**
     * 电脑背景图
     */
    PC_BACKGROUND(1),
    /**
     * 手机背景图
     */
    PHONE_BACKGROUND(2),
    /**
     * 头像
     */
    HEAD(3),
    /**
     * 文章背景图
     */
    WORD_HEAD(4);

    private int value;

    BlogImageEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
