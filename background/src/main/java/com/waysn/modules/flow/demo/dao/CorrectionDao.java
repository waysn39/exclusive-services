/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.flow.demo.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.flow.demo.entity.CorrectionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 转正申请
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface CorrectionDao extends BaseDao<CorrectionEntity> {

    void updateInstanceId(String instanceId, Long id);
}