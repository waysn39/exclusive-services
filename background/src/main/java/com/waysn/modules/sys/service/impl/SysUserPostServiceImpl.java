/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.modules.sys.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.waysn.comm.service.impl.BaseServiceImpl;
import com.waysn.modules.sys.dao.SysUserPostDao;
import com.waysn.modules.sys.entity.SysUserPostEntity;
import com.waysn.modules.sys.service.SysUserPostService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户岗位关系
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Service
public class SysUserPostServiceImpl extends BaseServiceImpl<SysUserPostDao, SysUserPostEntity> implements SysUserPostService {

    @Override
    public void saveOrUpdate(Long userId, List<Long> postIdList) {
        //先删除用户岗位关系
        deleteByUserIds(new Long[]{userId});

        //用户没有一个岗位权限的情况
        if (CollUtil.isEmpty(postIdList)) {
            return;
        }

        //保存角色用户关系
        for (Long postId : postIdList) {
            SysUserPostEntity sysUserPostEntity = new SysUserPostEntity();
            sysUserPostEntity.setUserId(userId);
            sysUserPostEntity.setPostId(postId);

            //保存
            insert(sysUserPostEntity);
        }
    }

    @Override
    public void deleteByPostIds(Long[] postIds) {
        baseDao.deleteByPostIds(postIds);
    }

    @Override
    public void deleteByUserIds(Long[] userIds) {
        baseDao.deleteByUserIds(userIds);
    }

    @Override
    public List<Long> getPostIdList(Long userId) {
        return baseDao.getPostIdList(userId);
    }
}