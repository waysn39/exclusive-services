package com.waysn.modules.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.constant.Constant;
import com.waysn.modules.game.dao.GameClassifyDao;
import com.waysn.modules.game.dto.GameClassifyDTO;
import com.waysn.modules.game.entity.GameClassifyEntity;
import com.waysn.modules.game.service.GameClassifyService;
import com.waysn.modules.security.user.SecurityUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 游戏分类
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
@Service
public class GameClassifyServiceImpl extends CrudServiceImpl<GameClassifyDao, GameClassifyEntity, GameClassifyDTO> implements GameClassifyService {

    @Override
    public QueryWrapper<GameClassifyEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<GameClassifyEntity> wrapper = new QueryWrapper<>();

        String classifyName = (String)params.get("classifyName");
        wrapper.eq(StringUtils.isNotBlank(classifyName), "classify_name", classifyName);
        String startDateTime = (String)params.get("startDateTime");
        String endDateTime = (String)params.get("endDateTime");
        wrapper.ge(StringUtils.isNotBlank(startDateTime), "update_date", startDateTime);
        wrapper.le(StringUtils.isNotBlank(endDateTime), "update_date", endDateTime);

        return wrapper;
    }


    @Override
    public List<GameClassifyEntity> getAllClassify() {
        QueryWrapper<GameClassifyEntity> wrapper = new QueryWrapper<>();
        return baseDao.selectList(wrapper);
    }
}