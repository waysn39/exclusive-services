/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.sms;

import cn.hutool.core.map.MapUtil;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.exception.ErrorCode;
import com.waysn.comm.exception.ServicesException;
import com.waysn.comm.utils.SpringContextUtils;
import com.waysn.modules.message.service.SysSmsLogService;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 腾讯云短信服务
 *
 * @author jinyiming waysn39@hotmail.com
 */
public class QcloudSmsService extends AbstractSmsService {
    public QcloudSmsService(SmsConfig config) {
        this.config = config;
    }

    @Override
    public void sendSms(String smsCode, String mobile, LinkedHashMap<String, String> params) {
        this.sendSms(smsCode, mobile, params, config.getQcloudSignName(), config.getQcloudTemplateId());
    }

    @Override
    public void sendSms(String smsCode, String mobile, LinkedHashMap<String, String> params, String signName, String template) {
        SmsSingleSender sender = new SmsSingleSender(config.getQcloudAppId(), config.getQcloudAppKey());

        //短信参数
        ArrayList<String> paramsList = new ArrayList<>();
        if (MapUtil.isNotEmpty(params)) {
            for (String value : params.values()) {
                paramsList.add(value);
            }
        }
        SmsSingleSenderResult result;
        try {
            result = sender.sendWithParam("86", mobile, Integer.parseInt(template), paramsList, signName, null, null);
        } catch (Exception e) {
            throw new ServicesException(ErrorCode.SEND_SMS_ERROR, e, "");
        }

        int status = Constant.SUCCESS;
        if (result.result != 0) {
            status = Constant.FAIL;
        }

        //保存短信记录
        SysSmsLogService sysSmsLogService = SpringContextUtils.getBean(SysSmsLogService.class);
        sysSmsLogService.save(smsCode, Constant.SmsService.QCLOUD.getValue(), mobile, params, status);

        if (status == Constant.FAIL) {
            throw new ServicesException(ErrorCode.SEND_SMS_ERROR, result.errMsg);
        }
    }
}
