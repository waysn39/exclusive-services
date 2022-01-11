/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.service;

import com.waysn.comm.service.BaseService;
import com.waysn.dto.LoginDTO;
import com.waysn.entity.UserEntity;

import java.util.Map;

/**
 * 用户
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface UserService extends BaseService<UserEntity> {

    UserEntity getByMobile(String mobile);

    UserEntity getUserByUserId(Long userId);

    /**
     * 用户登录
     * @param dto    登录表单
     * @return 返回登录信息
     */
    Map<String, Object> login(LoginDTO dto);
}
