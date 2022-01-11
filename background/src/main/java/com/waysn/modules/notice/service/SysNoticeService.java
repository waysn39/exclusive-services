/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.notice.service;

import com.waysn.comm.page.PageData;
import com.waysn.comm.service.CrudService;
import com.waysn.modules.notice.dto.SysNoticeDTO;
import com.waysn.modules.notice.entity.SysNoticeEntity;

import java.util.Map;

/**
 * 通知管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface SysNoticeService extends CrudService<SysNoticeEntity, SysNoticeDTO> {

    /**
     * 获取被通知的用户
     */
    PageData<SysNoticeDTO> getNoticeUserPage(Map<String, Object> params);

    /**
     * 获取我的通知列表
     */
    PageData<SysNoticeDTO> getMyNoticePage(Map<String, Object> params);
}