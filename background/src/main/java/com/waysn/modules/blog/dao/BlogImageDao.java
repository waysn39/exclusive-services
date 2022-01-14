package com.waysn.modules.blog.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.blog.entity.BlogImageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 博客图片管理
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-13
*/
@Mapper
public interface BlogImageDao extends BaseDao<BlogImageEntity> {
	
}