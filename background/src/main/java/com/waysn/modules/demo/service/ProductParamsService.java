package com.waysn.modules.demo.service;

import com.waysn.comm.service.BaseService;
import com.waysn.modules.demo.dto.ProductParamsDTO;
import com.waysn.modules.demo.entity.ProductParamsEntity;

import java.util.List;

/**
 * 产品参数管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface ProductParamsService extends BaseService<ProductParamsEntity> {

    void saveOrUpdate(Long productId, List<ProductParamsDTO> list);

    void deleteByProductIds(Long[] productIds);

    List<ProductParamsDTO> getList(Long productId);
}