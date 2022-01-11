package com.waysn.modules.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.blog.dao.NavbarinfoDao;
import com.waysn.modules.blog.dto.NavbarinfoDTO;
import com.waysn.modules.blog.entity.NavbarinfoEntity;
import com.waysn.modules.blog.service.NavbarinfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 博客导航
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-09
 */
@Service
public class NavbarinfoServiceImpl extends CrudServiceImpl<NavbarinfoDao, NavbarinfoEntity, NavbarinfoDTO> implements NavbarinfoService {

    @Override
    public QueryWrapper<NavbarinfoEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<NavbarinfoEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }


    @Override
    public List<NavbarinfoEntity> getAllNavbarInfo() {
        LambdaQueryWrapper<NavbarinfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(NavbarinfoEntity::getIsUsed, true);
        return baseDao.selectList(wrapper);
    }

    @Override
    public List<NavbarinfoEntity> getAllNavbarInfoByParent(String parentCode) {
        LambdaQueryWrapper<NavbarinfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(NavbarinfoEntity::getIsUsed, true);
        wrapper.eq(NavbarinfoEntity::getParentCode, parentCode);
        return baseDao.selectList(wrapper);
    }
}