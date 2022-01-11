package com.waysn.modules.mp.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.mp.dto.MpMenuDTO;
import com.waysn.modules.mp.entity.MpMenuEntity;

/**
 * 公众号自定义菜单
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface MpMenuService extends CrudService<MpMenuEntity, MpMenuDTO> {

    MpMenuDTO getByAppId(String appId);

    void deleteByAppId(String appId);
}