/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.controller;

import com.google.gson.Gson;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.utils.Result;
import com.waysn.modules.devtools.entity.GenParam;
import com.waysn.modules.sys.service.SysParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 代码生成参数配置
 *
 * @author jinyiming waysn39@hotmail.com
 */
@RestController
@RequestMapping("devtools/param")
public class GenParamController {
    @Autowired
    private SysParamsService sysParamsService;

    @GetMapping("info")
    public Result<GenParam> info() {
        GenParam param = sysParamsService.getValueObject(Constant.DEV_TOOLS_PARAM_KEY, GenParam.class);

        return new Result<GenParam>().ok(param);
    }

    @PostMapping
    public Result saveConfig(@RequestBody GenParam param) {
        sysParamsService.updateValueByCode(Constant.DEV_TOOLS_PARAM_KEY, new Gson().toJson(param));

        return new Result();
    }
}