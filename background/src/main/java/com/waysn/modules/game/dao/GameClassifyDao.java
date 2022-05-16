package com.waysn.modules.game.dao;

import com.waysn.comm.dao.BaseDao;
import com.waysn.modules.game.entity.GameClassifyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 游戏分类
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-05-16
*/
@Mapper
public interface GameClassifyDao extends BaseDao<GameClassifyEntity> {
	
}