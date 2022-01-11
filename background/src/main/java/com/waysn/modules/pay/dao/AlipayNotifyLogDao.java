/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.pay.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.pay.entity.AlipayNotifyLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付宝回调日志
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface AlipayNotifyLogDao extends BaseDao<AlipayNotifyLogEntity> {

}