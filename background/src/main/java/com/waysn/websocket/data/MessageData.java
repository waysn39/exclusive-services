/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.websocket.data;

import lombok.Data;

/**
 * 响应客户端数据
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class MessageData<T> {
    /**
     * 编码  0：文本消息  1：对象消息
     */
    private int type = 0;
    /**
     * 文本消息
     */
    private String msg;
    /**
     * 对象消息
     */
    private T data;

    public MessageData<T> data(T data) {
        this.setData(data);
        this.type = 1;
        return this;
    }

    public MessageData<T> msg(String msg) {
        this.msg = msg;
        return this;
    }
}
