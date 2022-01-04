/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.pay.controller;

import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.Result;
import com.waysn.modules.pay.dto.AlipayNotifyLogDTO;
import com.waysn.modules.pay.service.AlipayNotifyLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;


/**
* 支付宝回调日志
*
* @author Mark sunlightcs@gmail.com
*/
@RestController
@RequestMapping("pay/alipayNotifyLog")
public class AlipayNotifyLogController {
    @Autowired
    private AlipayNotifyLogService alipayNotifyLogService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("pay:alipayNotifyLog:all")
    public Result<PageData<AlipayNotifyLogDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<AlipayNotifyLogDTO> page = alipayNotifyLogService.page(params);

        return new Result<PageData<AlipayNotifyLogDTO>>().ok(page);
    }
}