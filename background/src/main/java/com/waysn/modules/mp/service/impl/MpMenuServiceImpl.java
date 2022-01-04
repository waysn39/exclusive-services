package com.waysn.modules.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.utils.ConvertUtils;
import com.waysn.modules.mp.service.MpMenuService;
import com.waysn.modules.mp.dao.MpMenuDao;
import com.waysn.modules.mp.dto.MpMenuDTO;
import com.waysn.modules.mp.entity.MpMenuEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 公众号自定义菜单
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class MpMenuServiceImpl extends CrudServiceImpl<MpMenuDao, MpMenuEntity, MpMenuDTO> implements MpMenuService {

    @Override
    public QueryWrapper<MpMenuEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<MpMenuEntity> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public MpMenuDTO getByAppId(String appId) {
        MpMenuEntity entity = baseDao.selectOne(new QueryWrapper<MpMenuEntity>().eq("app_id", appId));
        return ConvertUtils.sourceToTarget(entity, MpMenuDTO.class);
    }

    @Override
    public void deleteByAppId(String appId) {
        baseDao.delete(new QueryWrapper<MpMenuEntity>().eq("app_id", appId));
    }
}