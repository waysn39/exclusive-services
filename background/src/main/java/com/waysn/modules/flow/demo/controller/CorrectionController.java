/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */
package com.waysn.modules.flow.demo.controller;

import com.waysn.comm.utils.Result;
import com.waysn.comm.validator.ValidatorUtils;
import com.waysn.comm.validator.group.AddGroup;
import com.waysn.comm.validator.group.DefaultGroup;
import com.waysn.modules.flow.demo.dto.CorrectionDTO;
import com.waysn.modules.flow.demo.service.CorrectionService;
import com.waysn.modules.flow.service.FlowRunningService;
import com.waysn.modules.security.user.SecurityUser;
import com.waysn.modules.flow.dto.ProcessInstanceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 转正申请
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("flow/demo/correction")
@AllArgsConstructor
@Api(tags="转正申请")
public class CorrectionController {
    private final CorrectionService correctionService;
    private final FlowRunningService flowRunningService;

    @PostMapping("start")
    @ApiOperation("启动流程")
    @RequiresPermissions("sys:flow:all")
    public Result startProcess(@RequestBody CorrectionDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        //保存表单
        correctionService.save(dto);

        Map<String, Object> variables = new HashMap<>();
        variables.put("USERNAME", SecurityUser.getUserId().toString());
        ProcessInstanceDTO process = flowRunningService.startProcessInstanceById
                (dto.getProcessDefinitionId(), dto.getId() + "", variables);

        dto.setInstanceId(process.getProcessInstanceId());

        //更新流程实例ID
        correctionService.updateInstanceId(process.getProcessInstanceId(), dto.getId());

        return new Result();
    }

    @GetMapping("{id}")
    @ApiOperation("表单信息")
    @RequiresPermissions("sys:flow:all")
    public Result<CorrectionDTO> info(@PathVariable("id") Long id){
        CorrectionDTO correction = correctionService.get(id);

        return new Result<CorrectionDTO>().ok(correction);
    }

}
