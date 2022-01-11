/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.flow.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.flow.entity.FlowModelEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 模型管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface FlowModelDao extends BaseDao<FlowModelEntity> {

    List<FlowModelEntity> getList(Map<String, Object> params);

}
