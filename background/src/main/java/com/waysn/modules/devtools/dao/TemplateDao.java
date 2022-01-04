/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waysn.modules.devtools.entity.TemplateEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 模板管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface TemplateDao extends BaseMapper<TemplateEntity> {

    int updateStatusBatch(Map<String, Object> map);
}