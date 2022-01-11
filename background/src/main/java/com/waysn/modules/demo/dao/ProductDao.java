package com.waysn.modules.demo.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.demo.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface ProductDao extends BaseDao<ProductEntity> {
	
}