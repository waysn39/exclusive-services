package com.waysn.modules.mp.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.mp.entity.MpMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 公众号自定义菜单
*
* @author Mark sunlightcs@gmail.com
*/
@Mapper
public interface MpMenuDao extends BaseDao<MpMenuEntity> {
	
}