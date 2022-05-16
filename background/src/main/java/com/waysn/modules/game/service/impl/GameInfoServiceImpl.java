package com.waysn.modules.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.constant.Constant;
import com.waysn.modules.game.dao.GameInfoDao;
import com.waysn.modules.game.dto.GameInfoDTO;
import com.waysn.modules.game.entity.GameInfoEntity;
import com.waysn.modules.game.service.GameInfoService;
import com.waysn.modules.security.user.SecurityUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 游戏信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
@Service
public class GameInfoServiceImpl extends CrudServiceImpl<GameInfoDao, GameInfoEntity, GameInfoDTO> implements GameInfoService {

    @Override
    public QueryWrapper<GameInfoEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<GameInfoEntity> wrapper = new QueryWrapper<>();

        String gameTitle = (String)params.get("gameTitle");
        wrapper.eq(StringUtils.isNotBlank(gameTitle), "game_title", gameTitle);
        String gameCustomTitle = (String)params.get("gameCustomTitle");
        wrapper.eq(StringUtils.isNotBlank(gameCustomTitle), "game_custom_title", gameCustomTitle);
        String classifyName = (String)params.get("classifyName");
        wrapper.eq(StringUtils.isNotBlank(classifyName), "classify_name", classifyName);

        return wrapper;
    }


}