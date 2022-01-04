/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */
package com.waysn.modules.flow.controller;

import com.waysn.comm.annotation.LogOperation;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.Result;
import com.waysn.modules.flow.service.FlowRunningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * 运行中的流程
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/flow/running")
@AllArgsConstructor
@Api(tags="运行中的流程")
public class FlowRunningController {
    private final FlowRunningService flowRunningService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = "id", value = "实例ID", paramType = "query", dataType="String"),
        @ApiImplicitParam(name = "definitionKey", value = "definitionKey", paramType = "query", dataType="String")
    })
    @RequiresPermissions("sys:running:all")
    public Result<PageData<Map<String, Object>>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<Map<String, Object>> page = flowRunningService.page(params);

        return new Result<PageData<Map<String, Object>>>().ok(page);
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:running:all")
    @ApiImplicitParam(name = "id", value = "ID", paramType = "query", dataType="String")
    public Result deleteInstance(@PathVariable("id") String id) {
        flowRunningService.delete(id);
        return new Result();
    }

}