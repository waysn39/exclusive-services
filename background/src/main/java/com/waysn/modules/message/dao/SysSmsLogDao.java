package com.waysn.modules.message.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.message.entity.SysSmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信日志
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface SysSmsLogDao extends BaseDao<SysSmsLogEntity> {
	
}