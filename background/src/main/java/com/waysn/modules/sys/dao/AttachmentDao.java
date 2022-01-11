package com.waysn.modules.sys.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.sys.entity.AttachmentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 附件管理
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-11
*/
@Mapper
public interface AttachmentDao extends BaseDao<AttachmentEntity> {
	
}