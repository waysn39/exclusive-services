/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.flow.demo.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.flow.demo.dto.CorrectionDTO;
import com.waysn.modules.flow.demo.entity.CorrectionEntity;

/**
 * 转正申请
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface CorrectionService extends CrudService<CorrectionEntity, CorrectionDTO> {

    void updateInstanceId(String instanceId, Long id);
}