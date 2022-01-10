package com.waysn.modules.open.controller;

import com.waysn.comm.utils.Result;
import com.waysn.modules.blog.dto.NavbarinfoDTO;
import com.waysn.modules.blog.entity.NavbarinfoEntity;
import com.waysn.modules.blog.service.NavbarinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("open")
@Api(tags="OpenController")
public class OpenController {

    @Autowired
    private NavbarinfoService navbarinfoService;

    @GetMapping("/get/blog/navbar")
    @ApiOperation("获取博客导航栏信息")
    public Result<List<NavbarinfoEntity>> getBlogNavbar(){
        List<NavbarinfoEntity> data = navbarinfoService.getAllNavbarInfo();
        return new Result<List<NavbarinfoEntity>>().ok(data);
    }

}
