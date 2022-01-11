package com.waysn.modules.demo.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.demo.entity.ExcelDataEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Excel导入演示
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface ExcelDataDao extends BaseDao<ExcelDataEntity> {

}