package com.waysn.modules.mp.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.mp.entity.MpAccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 公众号账号管理
*
* @author Mark sunlightcs@gmail.com
*/
@Mapper
public interface MpAccountDao extends BaseDao<MpAccountEntity> {
	
}