/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.ureport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.ureport.entity.UReportDataEntity;
import com.waysn.modules.ureport.service.UReportDataService;
import com.waysn.modules.ureport.dao.UReportDataDao;
import com.waysn.modules.ureport.dto.UReportDataDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UReportDataServiceImpl extends CrudServiceImpl<UReportDataDao, UReportDataEntity, UReportDataDTO> implements UReportDataService {

    @Override
    public QueryWrapper<UReportDataEntity> getWrapper(Map<String, Object> params){
        String fileName = (String)params.get("fileName");

        QueryWrapper<UReportDataEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(fileName), "file_name", fileName);
        return wrapper;
    }

}
