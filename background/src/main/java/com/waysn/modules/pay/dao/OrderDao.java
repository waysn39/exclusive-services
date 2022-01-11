/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.pay.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.pay.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 订单
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface OrderDao extends BaseDao<OrderEntity> {

    /**
     * 支付成功
     */
    int paySuccess(@Param("orderId") Long orderId, @Param("status") Integer status, @Param("payAt") Date payAt);

    OrderEntity getByOrderId(Long orderId);
}