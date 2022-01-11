/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.flow.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.flow.demo.dao.CorrectionDao;
import com.waysn.modules.flow.demo.dto.CorrectionDTO;
import com.waysn.modules.flow.demo.entity.CorrectionEntity;
import com.waysn.modules.flow.demo.service.CorrectionService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 转正申请
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Service
public class CorrectionServiceImpl extends CrudServiceImpl<CorrectionDao, CorrectionEntity, CorrectionDTO> implements CorrectionService {

    @Override
    public QueryWrapper<CorrectionEntity> getWrapper(Map<String, Object> params) {

        return null;
    }

    @Override
    public void updateInstanceId(String instanceId, Long id) {
        baseDao.updateInstanceId(instanceId, id);
    }
}