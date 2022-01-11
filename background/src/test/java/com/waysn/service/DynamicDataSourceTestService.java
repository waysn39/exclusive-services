/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.service;

import com.waysn.commons.dynamic.datasource.annotation.DataSource;
import com.waysn.modules.sys.dao.SysUserDao;
import com.waysn.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试多数据源
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Service
//@DataSource("slave1")
public class DynamicDataSourceTestService {
    @Autowired
    private SysUserDao sysUserDao;

    //@Transactional
    public void updateUser(Long id) {
        SysUserEntity user = new SysUserEntity();
        user.setId(id);
        user.setMobile("13500000000");
        //sysUserDao.updateById(user);
        System.out.println(sysUserDao.selectById(id));
    }

    @DataSource("slave1")
    @Transactional
    public void updateUserBySlave1(Long id) {
        SysUserEntity user = new SysUserEntity();
        user.setId(id);
        user.setMobile("13500000001");
        //sysUserDao.updateById(user);
        System.out.println(sysUserDao.selectById(id));
    }

//    @DataSource("slave2")
//    @Transactional
//    public void updateUserBySlave2(Long id){
//        SysUserEntity user = new SysUserEntity();
//        user.setId(id);
//        user.setMobile("13500000002");
//        sysUserDao.updateById(user);
//
//        //测试事物
//        int i = 1/0;
//    }
}