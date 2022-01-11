package com.waysn.modules.demo.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.demo.dto.ProductDTO;
import com.waysn.modules.demo.entity.ProductEntity;

/**
 * 产品管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
public interface ProductService extends CrudService<ProductEntity, ProductDTO> {

}