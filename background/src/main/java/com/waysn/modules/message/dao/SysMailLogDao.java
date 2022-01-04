/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.message.entity.SysMailLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件发送记录
 * 
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysMailLogDao extends BaseDao<SysMailLogEntity> {
	
}
