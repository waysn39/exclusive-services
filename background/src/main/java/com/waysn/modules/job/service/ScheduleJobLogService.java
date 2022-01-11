/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.job.service;

import com.waysn.comm.page.PageData;
import com.waysn.comm.service.BaseService;
import com.waysn.modules.job.dto.ScheduleJobLogDTO;
import com.waysn.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface ScheduleJobLogService extends BaseService<ScheduleJobLogEntity> {

    PageData<ScheduleJobLogDTO> page(Map<String, Object> params);

    ScheduleJobLogDTO get(Long id);
}
