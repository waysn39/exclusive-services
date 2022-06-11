/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.ureport.controller;

import com.waysn.comm.annotation.LogOperation;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.Result;
import com.waysn.comm.validator.AssertUtils;
import com.waysn.modules.ureport.dto.UReportDataDTO;
import com.waysn.modules.ureport.service.UReportDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Map;

/**
 * 报表管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@RestController
@RequestMapping("sys/ureport")
@Api(tags = "报表管理")
public class UReportController {
    @Autowired
    private UReportDataService ureportDataService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "fileName", value = "文件名", paramType = "query", dataType = "String"),
    })
    @RequiresPermissions("sys:ureport:all")
    public Result<PageData<UReportDataDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<UReportDataDTO> page = ureportDataService.page(params);

        return new Result<PageData<UReportDataDTO>>().ok(page);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:ureport:all")
    public Result<Boolean> delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        ureportDataService.deleteBatchIds(Arrays.asList(ids));
        return new Result<Boolean>().ok(Boolean.TRUE);
    }

}