package com.waysn.modules.open.controller;

import com.alibaba.fastjson.JSON;
import com.waysn.comm.utils.Result;
import com.waysn.comm.utils.StringUtils;
import com.waysn.modules.blog.entity.NavbarinfoEntity;
import com.waysn.modules.blog.service.NavbarinfoService;
import com.waysn.modules.blog.vo.NavbarinfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("open")
@Api(tags = "OpenController")
public class OpenController {
    @Resource
    private NavbarinfoService navbarinfoService;

    @GetMapping("/get/blog/navbar")
    @ApiOperation("获取博客导航栏信息")
    public Result getBlogNavbar() {
        List<NavbarinfoEntity> data = navbarinfoService.getAllNavbarInfoByParent("root");
        List<NavbarinfoVo> navbarinfoVoList = new ArrayList<>();
        for (NavbarinfoEntity item : data) {
            NavbarinfoVo navbarinfoVo = mapNavbarInfoVo(item);
            getChildNavbar(item.getNavbarCode(), navbarinfoVo);
            navbarinfoVoList.add(navbarinfoVo);
        }
        return new Result().ok(JSON.parse(JSON.toJSONString(navbarinfoVoList)));
    }

    private NavbarinfoVo mapNavbarInfoVo(NavbarinfoEntity item) {
        NavbarinfoVo navbarinfoVo = new NavbarinfoVo();
        navbarinfoVo.setNavbarName(item.getNavbarName());
        navbarinfoVo.setNavbarLink(item.getNavbarLink());
        if (StringUtils.isNullOrEmpty(item.getNavbarLink())) {
            navbarinfoVo.setNavbarLink(null);
        }
        navbarinfoVo.setNavbarIconClass(item.getNavbarIconClass());
        return navbarinfoVo;
    }

    private void getChildNavbar(String parentCode, NavbarinfoVo currentItem) {
        List<NavbarinfoEntity> childs = navbarinfoService.getAllNavbarInfoByParent(parentCode);
        if (childs.size() > 0) {
            List<NavbarinfoVo> navbarinfoVoList = new ArrayList<>();
            for (NavbarinfoEntity item : childs) {
                NavbarinfoVo navbarinfoVo = mapNavbarInfoVo(item);
                getChildNavbar(item.getNavbarCode(), navbarinfoVo);
                navbarinfoVoList.add(navbarinfoVo);
            }
            currentItem.setChildren(navbarinfoVoList);
        } else {
            currentItem.setChildren(null);
        }
    }
}
