package com.waysn.modules.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.constant.Constant;
import com.waysn.modules.game.dao.GameAccessLogDao;
import com.waysn.modules.game.dto.GameAccessLogDTO;
import com.waysn.modules.game.entity.GameAccessLogEntity;
import com.waysn.modules.game.service.GameAccessLogService;
import com.waysn.modules.security.user.SecurityUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 游戏访问日志表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Service
public class GameAccessLogServiceImpl extends CrudServiceImpl<GameAccessLogDao, GameAccessLogEntity, GameAccessLogDTO> implements GameAccessLogService {

    @Override
    public QueryWrapper<GameAccessLogEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<GameAccessLogEntity> wrapper = new QueryWrapper<>();


        return wrapper;
    }


}