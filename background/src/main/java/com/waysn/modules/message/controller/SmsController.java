/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.controller;

import com.waysn.comm.annotation.LogOperation;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.Result;
import com.waysn.comm.validator.ValidatorUtils;
import com.waysn.comm.validator.group.AliyunGroup;
import com.waysn.comm.validator.group.QcloudGroup;
import com.waysn.comm.validator.group.QiniuGroup;
import com.waysn.modules.message.dto.SysSmsDTO;
import com.waysn.modules.message.service.SysSmsService;
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
 * 短信服务
 *
 * @author jinyiming waysn39@hotmail.com
 */
@RestController
@RequestMapping("sys/sms")
@Api(tags = "短信服务")
public class SmsController {
    @Autowired
    private SysSmsService sysSmsService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("sys:sms:all")
    public Result<PageData<SysSmsDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<SysSmsDTO> page = sysSmsService.page(params);

        return new Result<PageData<SysSmsDTO>>().ok(page);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:sms:all")
    public Result save(@RequestBody SysSmsDTO dto) {
        //校验数据
        if (dto.getPlatform() == Constant.SmsService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(dto.getConfig(), AliyunGroup.class);
        } else if (dto.getPlatform() == Constant.SmsService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(dto.getConfig(), QcloudGroup.class);
        } else if (dto.getPlatform() == Constant.SmsService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(dto.getConfig(), QiniuGroup.class);
        }

        sysSmsService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:sms:all")
    public Result update(@RequestBody SysSmsDTO dto) {
        //校验数据
        if (dto.getPlatform() == Constant.SmsService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(dto.getConfig(), AliyunGroup.class);
        } else if (dto.getPlatform() == Constant.SmsService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(dto.getConfig(), QcloudGroup.class);
        } else if (dto.getPlatform() == Constant.SmsService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(dto.getConfig(), QiniuGroup.class);
        }

        sysSmsService.update(dto);

        return new Result();
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:sms:all")
    public Result<SysSmsDTO> info(@PathVariable("id") Long id) {
        SysSmsDTO sms = sysSmsService.get(id);

        return new Result<SysSmsDTO>().ok(sms);
    }

    @PostMapping("send")
    @ApiOperation("发送短信")
    @LogOperation("发送短信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smsCode", value = "短信编码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "mobile", value = "手机好号", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "params", value = "参数", paramType = "query", required = true, dataType = "String")
    })
    @RequiresPermissions("sys:sms:all")
    public Result send(String smsCode, String mobile, String params) {
        sysSmsService.send(smsCode, mobile, params);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:sms:all")
    public Result delete(@RequestBody Long[] ids) {
        sysSmsService.deleteBatchIds(Arrays.asList(ids));

        return new Result();
    }

}