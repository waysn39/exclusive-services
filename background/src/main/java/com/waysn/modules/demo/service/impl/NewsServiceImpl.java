/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.waysn.comm.annotation.DataFilter;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.service.impl.BaseServiceImpl;
import com.waysn.comm.utils.ConvertUtils;
import com.waysn.modules.demo.dao.NewsDao;
import com.waysn.modules.demo.dto.NewsDTO;
import com.waysn.modules.demo.entity.NewsEntity;
import com.waysn.modules.demo.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class NewsServiceImpl extends BaseServiceImpl<NewsDao, NewsEntity> implements NewsService {

    /**
     * mybatis数据权限演示
     */
    @Override
    @DataFilter
    public PageData<NewsDTO> page(Map<String, Object> params) {
        paramsToLike(params, "title");

        //分页
        IPage<NewsEntity> page = getPage(params, Constant.CREATE_DATE, false);

        //查询
        List<NewsEntity> list = baseDao.getList(params);

        return getPageData(list, page.getTotal(), NewsDTO.class);
    }

//    /**
//     * mybatis-plus数据权限演示
//     */
//    @Override
//    @DataFilter
//    public PageData<NewsDTO> page(Map<String, Object> params) {
//        IPage<NewsEntity> page = baseDao.selectPage(
//            getPage(params, Constant.CREATE_DATE, false),
//            getWrapper(params)
//        );
//        return getPageData(page, NewsDTO.class);
//    }
//
//    private QueryWrapper<NewsEntity> getWrapper(Map<String, Object> params){
//        String title = (String)params.get("title");
//        String startDate = (String)params.get("startDate");
//        String endDate = (String)params.get("endDate");
//
//        QueryWrapper<NewsEntity> wrapper = new QueryWrapper<>();
//        wrapper.like(StringUtils.isNotBlank(title), "title", title);
//        wrapper.ge(StringUtils.isNotBlank(startDate),"pub_date", startDate);
//        wrapper.le(StringUtils.isNotBlank(endDate),"pub_date", endDate);
//
//        //数据过滤
//        wrapper.apply(params.get(Constant.SQL_FILTER) != null, params.get(Constant.SQL_FILTER).toString());
//
//        return wrapper;
//    }

    @Override
    public NewsDTO get(Long id) {
        NewsEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, NewsDTO.class);
    }

    @Override
    public void save(NewsDTO dto) {
        NewsEntity entity = ConvertUtils.sourceToTarget(dto, NewsEntity.class);

        insert(entity);
    }

    @Override
    public void update(NewsDTO dto) {
        NewsEntity entity = ConvertUtils.sourceToTarget(dto, NewsEntity.class);

        updateById(entity);
    }

}
