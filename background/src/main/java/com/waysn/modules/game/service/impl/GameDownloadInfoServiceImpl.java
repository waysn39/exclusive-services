package com.waysn.modules.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.constant.Constant;
import com.waysn.modules.game.dao.GameDownloadInfoDao;
import com.waysn.modules.game.dto.GameDownloadInfoDTO;
import com.waysn.modules.game.entity.GameDownloadInfoEntity;
import com.waysn.modules.game.service.GameDownloadInfoService;
import com.waysn.modules.security.user.SecurityUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 游戏下载信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Service
public class GameDownloadInfoServiceImpl extends CrudServiceImpl<GameDownloadInfoDao, GameDownloadInfoEntity, GameDownloadInfoDTO> implements GameDownloadInfoService {

    @Override
    public QueryWrapper<GameDownloadInfoEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<GameDownloadInfoEntity> wrapper = new QueryWrapper<>();


        return wrapper;
    }


}