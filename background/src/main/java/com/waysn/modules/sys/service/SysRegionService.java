/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.sys.service;

import com.waysn.comm.service.BaseService;
import com.waysn.modules.sys.dto.SysRegionDTO;
import com.waysn.modules.sys.dto.region.RegionProvince;
import com.waysn.modules.sys.entity.SysRegionEntity;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 * 
 * @author Mark sunlightcs@gmail.com
 */
public interface SysRegionService extends BaseService<SysRegionEntity> {

	List<SysRegionDTO> list(Map<String, Object> params);

	List<Map<String, Object>> getTreeList();

	SysRegionDTO get(Long id);

	void save(SysRegionDTO dto);

	void update(SysRegionDTO dto);

	void delete(Long id);

	int getCountByPid(Long pid);

	List<RegionProvince> getRegion(boolean threeLevel);
}