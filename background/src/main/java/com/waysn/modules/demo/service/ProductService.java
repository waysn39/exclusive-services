package com.waysn.modules.demo.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.demo.entity.ProductEntity;
import com.waysn.modules.demo.dto.ProductDTO;

/**
 * 产品管理
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface ProductService extends CrudService<ProductEntity, ProductDTO> {

}