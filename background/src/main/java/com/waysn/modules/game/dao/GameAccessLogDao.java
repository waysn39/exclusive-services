package com.waysn.modules.game.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.game.entity.GameAccessLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 游戏访问日志表
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-06-30
*/
@Mapper
public interface GameAccessLogDao extends BaseDao<GameAccessLogEntity> {
	
}