/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.security.service;

import com.waysn.comm.page.PageData;
import com.waysn.comm.service.BaseService;
import com.waysn.comm.utils.Result;
import com.waysn.modules.security.entity.SysUserTokenEntity;
import com.waysn.modules.sys.entity.SysOnlineEntity;

import java.util.Map;

/**
 * 用户Token
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface SysUserTokenService extends BaseService<SysUserTokenEntity> {

    /**
     * 生成token
     * @param userId  用户ID
     */
    Result createToken(Long userId);

    /**
     * 退出
     * @param userId  用户ID
     */
    void logout(Long userId);

    /**
     * 在线用户分页
     */
    PageData<SysOnlineEntity> onlinePage(Map<String, Object> params);

}