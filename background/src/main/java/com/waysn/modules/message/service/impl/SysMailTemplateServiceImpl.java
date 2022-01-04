/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.exception.ErrorCode;
import com.waysn.comm.exception.RenException;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.message.dao.SysMailTemplateDao;
import com.waysn.modules.message.dto.SysMailTemplateDTO;
import com.waysn.modules.message.email.EmailUtils;
import com.waysn.modules.message.entity.SysMailTemplateEntity;
import com.waysn.modules.message.service.SysMailTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SysMailTemplateServiceImpl extends CrudServiceImpl<SysMailTemplateDao, SysMailTemplateEntity, SysMailTemplateDTO> implements SysMailTemplateService {
    @Autowired
    private EmailUtils emailUtils;

    @Override
    public QueryWrapper<SysMailTemplateEntity> getWrapper(Map<String, Object> params) {
        String name = (String)params.get("name");

        QueryWrapper<SysMailTemplateEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name), "name", name);

        return wrapper;
    }

    @Override
    public boolean sendMail(Long id, String mailTo, String mailCc, String params) throws Exception{
        Map<String, Object> map = null;
        try {
            if(StringUtils.isNotEmpty(params)){
                map = JSON.parseObject(params, Map.class);
            }
        }catch (Exception e){
            throw new RenException(ErrorCode.JSON_FORMAT_ERROR);
        }
        String[] to = new String[]{mailTo};
        String[] cc = StringUtils.isBlank(mailCc) ? null : new String[]{mailCc};

        return emailUtils.sendMail(id, to, cc, map);
    }
}
