/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.pay.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.pay.dto.AlipayNotifyLogDTO;
import com.waysn.modules.pay.entity.AlipayNotifyLogEntity;

/**
 * 支付宝回调日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface AlipayNotifyLogService extends CrudService<AlipayNotifyLogEntity, AlipayNotifyLogDTO> {

}