package com.waysn.modules.game.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.game.dto.GameAccessLogDTO;
import com.waysn.modules.game.entity.GameAccessLogEntity;

/**
 * 游戏访问日志表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
public interface GameAccessLogService extends CrudService<GameAccessLogEntity, GameAccessLogDTO> {

}