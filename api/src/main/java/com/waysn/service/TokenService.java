/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.service;

import com.waysn.comm.service.BaseService;
import com.waysn.entity.TokenEntity;

/**
 * 用户Token
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface TokenService extends BaseService<TokenEntity> {

    TokenEntity getByToken(String token);

    /**
     * 生成token
     * @param userId  用户ID
     * @return 返回token信息
     */
    TokenEntity createToken(Long userId);

    /**
     * 设置token过期
     * @param userId 用户ID
     */
    void expireToken(Long userId);

}
