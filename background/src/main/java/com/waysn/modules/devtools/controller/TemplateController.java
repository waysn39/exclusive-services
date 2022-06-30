/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.controller;

import com.google.common.collect.Maps;
import com.waysn.comm.exception.ServicesException;
import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.Result;
import com.waysn.modules.devtools.entity.TemplateEntity;
import com.waysn.modules.devtools.service.TemplateService;
import com.waysn.modules.devtools.utils.GenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 模板管理
 *
 * @author jinyiming waysn39@hotmail.com
 */
@RestController
@RequestMapping("devtools/template")
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @GetMapping("page")
    public Result<PageData<TemplateEntity>> page(@RequestParam Map<String, Object> params) {
        PageData<TemplateEntity> page = templateService.page(params);

        return new Result<PageData<TemplateEntity>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<TemplateEntity> get(@PathVariable("id") Long id) {
        TemplateEntity data = templateService.selectById(id);

        return new Result<TemplateEntity>().ok(data);
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody TemplateEntity entity) {
        try {
            //检查模板语法是否正确
            GenUtils.getTemplateContent(entity.getContent(), Maps.newHashMap());
        } catch (Exception e) {
            throw new ServicesException("模板语法错误，请查看控制台报错信息！", e);
        }

        templateService.insert(entity);

        return new Result<Boolean> ().ok(Boolean.TRUE);
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody TemplateEntity entity) {
        try {
            //检查模板语法是否正确
            GenUtils.getTemplateContent(entity.getContent(), Maps.newHashMap());
        } catch (Exception e) {
            throw new ServicesException("模板语法错误，请查看控制台报错信息！", e);
        }
        templateService.updateById(entity);

        return new Result<Boolean> ().ok(Boolean.TRUE);
    }

    @DeleteMapping
    public Result<Boolean> delete(@RequestBody Long[] ids) {
        templateService.deleteBatchIds(Arrays.asList(ids));

        return new Result<Boolean> ().ok(Boolean.TRUE);
    }

    /**
     * 启用
     */
    @PutMapping("enabled")
    public Result<Boolean> enabled(@RequestBody Long[] ids) {
        templateService.updateStatusBatch(ids, 0);

        return new Result<Boolean> ().ok(Boolean.TRUE);
    }

    /**
     * 禁用
     */
    @PutMapping("disabled")
    public Result<Boolean> disabled(@RequestBody Long[] ids) {
        templateService.updateStatusBatch(ids, 1);

        return new Result<Boolean> ().ok(Boolean.TRUE);
    }
}