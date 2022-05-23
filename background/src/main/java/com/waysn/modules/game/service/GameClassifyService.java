package com.waysn.modules.game.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.game.dto.GameClassifyDTO;
import com.waysn.modules.game.entity.GameClassifyEntity;

import java.util.List;

/**
 * 游戏分类
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
public interface GameClassifyService extends CrudService<GameClassifyEntity, GameClassifyDTO> {
    List<GameClassifyEntity> getAllClassify();
}