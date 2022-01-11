/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.websocket.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.websocket.Session;

/**
 * WebSocket连接数据
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Data
@AllArgsConstructor
public class WebSocketData {
    private Long userId;
    private Session session;
}