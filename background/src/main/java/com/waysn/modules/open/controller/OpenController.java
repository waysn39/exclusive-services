package com.waysn.modules.open.controller;

import com.alibaba.fastjson.JSON;
import com.waysn.comm.utils.Result;
import com.waysn.modules.blog.dto.NavbarinfoDTO;
import com.waysn.modules.blog.entity.NavbarinfoEntity;
import com.waysn.modules.blog.service.NavbarinfoService;
import com.waysn.modules.blog.vo.NavbarinfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("open")
@Api(tags="OpenController")
public class OpenController {

    @Resource
    private NavbarinfoService navbarinfoService;

    @GetMapping("/get/blog/navbar")
    @ApiOperation("获取博客导航栏信息")
    public Result getBlogNavbar(){
            List<NavbarinfoEntity> data = navbarinfoService.getAllNavbarInfo();
            List<NavbarinfoVo> navbarinfoVoList = new ArrayList<>();
            for (NavbarinfoEntity item : data){
                NavbarinfoVo navbarinfoVo = new NavbarinfoVo();
                navbarinfoVo.setNavbarName(item.getNavbarName());
                navbarinfoVo.setNavbarLink(item.getNavbarLink());
                navbarinfoVo.setNavbarIconClass(item.getNavbarIconClass());
                navbarinfoVoList.add(navbarinfoVo);
            }
            return new Result().ok(JSON.parse(JSON.toJSONString(navbarinfoVoList)));
        }

}
