/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.message.dto.SysMailTemplateDTO;
import com.waysn.modules.message.entity.SysMailTemplateEntity;

/**
 * 邮件模板
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysMailTemplateService extends CrudService<SysMailTemplateEntity, SysMailTemplateDTO> {

    /**
     * 发送邮件
     * @param id           邮件模板ID
     * @param mailTo       收件人
     * @param mailCc       抄送
     * @param params       模板参数
     */
    boolean sendMail(Long id, String mailTo, String mailCc, String params) throws Exception;
}