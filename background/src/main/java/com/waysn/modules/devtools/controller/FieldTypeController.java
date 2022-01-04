/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.devtools.controller;

import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.Result;
import com.waysn.modules.devtools.entity.FieldTypeEntity;
import com.waysn.modules.devtools.service.FieldTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 字段类型管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("devtools/fieldtype")
public class FieldTypeController {
    @Autowired
    private FieldTypeService fieldTypeService;

    @GetMapping("page")
    public Result<PageData<FieldTypeEntity>> page(@RequestParam Map<String, Object> params){
        PageData<FieldTypeEntity> page = fieldTypeService.page(params);

        return new Result<PageData<FieldTypeEntity>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<FieldTypeEntity> get(@PathVariable("id") Long id){
        FieldTypeEntity data = fieldTypeService.selectById(id);

        return new Result<FieldTypeEntity>().ok(data);
    }

    @GetMapping("list")
    public Result<Set<String>> list(){
        Set<String> set = fieldTypeService.list();

        return new Result<Set<String>>().ok(set);
    }

    @PostMapping
    public Result save(@RequestBody FieldTypeEntity entity){
        fieldTypeService.insert(entity);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody FieldTypeEntity entity){
        fieldTypeService.updateById(entity);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        fieldTypeService.deleteBatchIds(Arrays.asList(ids));

        return new Result();
    }
}