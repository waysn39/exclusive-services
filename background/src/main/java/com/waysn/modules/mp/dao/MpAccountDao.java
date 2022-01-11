package com.waysn.modules.mp.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.mp.entity.MpAccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公众号账号管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Mapper
public interface MpAccountDao extends BaseDao<MpAccountEntity> {

}