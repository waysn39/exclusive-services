/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.notice.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.notice.entity.SysNoticeUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 我的通知
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface SysNoticeUserDao extends BaseDao<SysNoticeUserEntity> {
    /**
     * 通知全部用户
     */
    void insertAllUser(SysNoticeUserEntity entity);

    /**
     * 未读的通知数
     * @param receiverId  接收者ID
     */
    int getUnReadNoticeCount(Long receiverId);
}