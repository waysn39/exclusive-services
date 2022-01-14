package com.waysn.modules.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.constant.Constant;
import com.waysn.modules.blog.dao.BlogImageDao;
import com.waysn.modules.blog.dto.BlogImageDTO;
import com.waysn.modules.blog.entity.BlogImageEntity;
import com.waysn.modules.blog.service.BlogImageService;
import com.waysn.modules.security.user.SecurityUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 博客图片管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-13
 */
@Service
public class BlogImageServiceImpl extends CrudServiceImpl<BlogImageDao, BlogImageEntity, BlogImageDTO> implements BlogImageService {

    @Override
    public QueryWrapper<BlogImageEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<BlogImageEntity> wrapper = new QueryWrapper<>();


        return wrapper;
    }


}