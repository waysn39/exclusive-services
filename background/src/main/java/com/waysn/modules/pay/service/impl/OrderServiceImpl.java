/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.pay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.security.user.SecurityUser;
import com.waysn.modules.pay.dao.OrderDao;
import com.waysn.modules.pay.dto.OrderDTO;
import com.waysn.modules.pay.entity.OrderEntity;
import com.waysn.modules.pay.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * 订单
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class OrderServiceImpl extends CrudServiceImpl<OrderDao, OrderEntity, OrderDTO> implements OrderService {

    @Override
    public QueryWrapper<OrderEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<OrderEntity> wrapper = new QueryWrapper<>();

        String orderId = (String)params.get("orderId");
        wrapper.eq(StringUtils.isNotBlank(orderId), "order_id", orderId);

        String status = (String)params.get("status");
        wrapper.eq(StringUtils.isNotBlank(status), "status", status);

        String userId = (String)params.get("userId");
        wrapper.eq(StringUtils.isNotBlank(userId), "user_id", userId);

        wrapper.orderByDesc("create_date");

        return wrapper;
    }

    @Override
    public void save(OrderDTO dto) {
        dto.setOrderId(IdWorker.getId());
        dto.setUserId(SecurityUser.getUserId());
        dto.setStatus(Constant.OrderStatus.WAITING.getValue());
        super.save(dto);
    }

    @Override
    public OrderEntity getByOrderId(Long orderId) {
        return baseDao.getByOrderId(orderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void paySuccess(OrderEntity order) {
        baseDao.paySuccess(order.getOrderId(), Constant.OrderStatus.FINISH.getValue(), new Date());
    }
}