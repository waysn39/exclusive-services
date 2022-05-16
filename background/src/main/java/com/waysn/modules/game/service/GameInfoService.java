package com.waysn.modules.game.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.game.dto.GameInfoDTO;
import com.waysn.modules.game.entity.GameInfoEntity;

/**
 * 游戏信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
public interface GameInfoService extends CrudService<GameInfoEntity, GameInfoDTO> {

}