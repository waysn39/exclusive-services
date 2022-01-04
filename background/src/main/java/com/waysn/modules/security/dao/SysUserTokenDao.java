/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.security.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.security.entity.SysUserTokenEntity;
import com.waysn.modules.sys.entity.SysOnlineEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统用户Token
 * 
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserTokenEntity> {

    SysUserTokenEntity getByToken(String token);

    SysUserTokenEntity getByUserId(Long userId);

    void logout(@Param("userId") Long userId, @Param("expireDate") Date expireDate);

    /**
     * 获取在线用户列表
     */
    List<SysOnlineEntity> getOnlineList(Map<String, Object> params);
}
