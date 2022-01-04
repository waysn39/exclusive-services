/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.demo.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.demo.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 新闻
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface NewsDao extends BaseDao<NewsEntity> {

    List<NewsEntity> getList(Map<String, Object> params);
	
}
