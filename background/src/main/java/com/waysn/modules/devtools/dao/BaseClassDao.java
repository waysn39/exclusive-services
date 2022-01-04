/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waysn.modules.devtools.entity.BaseClassEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 基类管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface BaseClassDao extends BaseMapper<BaseClassEntity> {
	
}