/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.message.dto.SysSmsDTO;
import com.waysn.modules.message.entity.SysSmsEntity;

/**
 * 短信
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysSmsService extends CrudService<SysSmsEntity, SysSmsDTO> {

    /**
     * 发送短信
     * @param smsCode   短信编码
     * @param mobile   手机号
     * @param params   短信参数
     */
    void send(String smsCode, String mobile, String params);

    SysSmsEntity getBySmsCode(String smsCode);

}

