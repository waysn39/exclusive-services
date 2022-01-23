package com.waysn.modules.blog.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.blog.entity.BlogLineWordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 博客一句话
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-23
*/
@Mapper
public interface BlogLineWordDao extends BaseDao<BlogLineWordEntity> {
	
}