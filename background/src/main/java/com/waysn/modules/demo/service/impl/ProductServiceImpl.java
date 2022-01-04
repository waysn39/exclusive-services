package com.waysn.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.demo.service.ProductParamsService;
import com.waysn.modules.demo.dao.ProductDao;
import com.waysn.modules.demo.dto.ProductDTO;
import com.waysn.modules.demo.dto.ProductParamsDTO;
import com.waysn.modules.demo.entity.ProductEntity;
import com.waysn.modules.demo.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 产品管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class ProductServiceImpl extends CrudServiceImpl<ProductDao, ProductEntity, ProductDTO> implements ProductService {
    @Autowired
    private ProductParamsService productParamsService;

    @Override
    public QueryWrapper<ProductEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        return wrapper;
    }

    @Override
    public ProductDTO get(Long id) {
        ProductDTO dto = super.get(id);

        // 获取子表数据
        List<ProductParamsDTO> subList = productParamsService.getList(id);
        dto.setSubList(subList);

        return dto;
    }

    @Override
    @Transactional
    public void save(ProductDTO dto) {
        super.save(dto);

        // 保存子表数据
        productParamsService.saveOrUpdate(dto.getId(), dto.getSubList());
    }

    @Override
    @Transactional
    public void update(ProductDTO dto) {
        super.update(dto);

        // 更新子表数据
        productParamsService.saveOrUpdate(dto.getId(), dto.getSubList());
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        super.delete(ids);

        // 删除子表数据
        productParamsService.deleteByProductIds(ids);
    }
}