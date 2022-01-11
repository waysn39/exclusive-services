package com.waysn.modules.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.mp.dao.MpAccountDao;
import com.waysn.modules.mp.dto.MpAccountDTO;
import com.waysn.modules.mp.entity.MpAccountEntity;
import com.waysn.modules.mp.service.MpAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 公众号账号管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Service
public class MpAccountServiceImpl extends CrudServiceImpl<MpAccountDao, MpAccountEntity, MpAccountDTO> implements MpAccountService {

    @Override
    public QueryWrapper<MpAccountEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<MpAccountEntity> wrapper = new QueryWrapper<>();

        String name = (String) params.get("name");
        wrapper.like(StringUtils.isNotBlank(name), "name", name);

        String appId = (String) params.get("appId");
        wrapper.like(StringUtils.isNotBlank(appId), "app_id", appId);

        return wrapper;
    }

}