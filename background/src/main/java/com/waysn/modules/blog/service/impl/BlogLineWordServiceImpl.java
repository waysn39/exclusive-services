package com.waysn.modules.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.modules.blog.dao.BlogLineWordDao;
import com.waysn.modules.blog.dto.BlogLineWordDTO;
import com.waysn.modules.blog.entity.BlogLineWordEntity;
import com.waysn.modules.blog.service.BlogLineWordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 博客一句话
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-23
 */
@Service
public class BlogLineWordServiceImpl extends CrudServiceImpl<BlogLineWordDao, BlogLineWordEntity, BlogLineWordDTO> implements BlogLineWordService {

    @Override
    public QueryWrapper<BlogLineWordEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<BlogLineWordEntity> wrapper = new QueryWrapper<>();
        String lineWord = (String) params.get("lineWord");
        wrapper.eq(StringUtils.isNotBlank(lineWord), "line_word", lineWord);

        return wrapper;
    }


    @Override
    public List<BlogLineWordEntity> getAllWord() {
        LambdaQueryWrapper<BlogLineWordEntity> wrapper = new LambdaQueryWrapper<BlogLineWordEntity>();
        return baseDao.selectList(wrapper);
    }
}