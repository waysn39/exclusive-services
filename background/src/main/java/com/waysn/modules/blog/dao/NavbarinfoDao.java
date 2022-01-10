package com.waysn.modules.blog.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.blog.entity.NavbarinfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 博客导航
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-09
*/
@Mapper
public interface NavbarinfoDao extends BaseDao<NavbarinfoEntity> {
	
}