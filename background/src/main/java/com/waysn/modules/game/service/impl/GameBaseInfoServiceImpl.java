package com.waysn.modules.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.constant.Constant;
import com.waysn.modules.game.dao.GameBaseInfoDao;
import com.waysn.modules.game.dto.GameBaseInfoDTO;
import com.waysn.modules.game.entity.GameBaseInfoEntity;
import com.waysn.modules.game.service.GameBaseInfoService;
import com.waysn.modules.security.user.SecurityUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 游戏基础信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Service
public class GameBaseInfoServiceImpl extends CrudServiceImpl<GameBaseInfoDao, GameBaseInfoEntity, GameBaseInfoDTO> implements GameBaseInfoService {

    @Override
    public QueryWrapper<GameBaseInfoEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<GameBaseInfoEntity> wrapper = new QueryWrapper<>();


        return wrapper;
    }


}