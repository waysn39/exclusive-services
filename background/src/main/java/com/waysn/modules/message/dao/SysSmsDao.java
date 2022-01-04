/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.message.entity.SysSmsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信
 * 
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysSmsDao extends BaseDao<SysSmsEntity> {
	
}
