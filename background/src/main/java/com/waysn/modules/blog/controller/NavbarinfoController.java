package com.waysn.modules.blog.controller;

import com.waysn.comm.annotation.LogOperation;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.ExcelUtils;
import com.waysn.comm.utils.Result;
import com.waysn.comm.validator.AssertUtils;
import com.waysn.comm.validator.ValidatorUtils;
import com.waysn.comm.validator.group.AddGroup;
import com.waysn.comm.validator.group.DefaultGroup;
import com.waysn.comm.validator.group.UpdateGroup;
import com.waysn.modules.blog.dto.NavbarinfoDTO;
import com.waysn.modules.blog.excel.NavbarinfoExcel;
import com.waysn.modules.blog.service.NavbarinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
* 博客导航
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-09
*/
@RestController
@RequestMapping("blog/navbarinfo")
@Api(tags="博客导航")
public class NavbarinfoController {
    @Autowired
    private NavbarinfoService navbarinfoService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("blog:navbarinfo:page")
    public Result<PageData<NavbarinfoDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<NavbarinfoDTO> page = navbarinfoService.page(params);

        return new Result<PageData<NavbarinfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("blog:navbarinfo:info")
    public Result<NavbarinfoDTO> get(@PathVariable("id") Long id){
        NavbarinfoDTO data = navbarinfoService.get(id);

        return new Result<NavbarinfoDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("blog:navbarinfo:save")
    public Result save(@RequestBody NavbarinfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        navbarinfoService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("blog:navbarinfo:update")
    public Result update(@RequestBody NavbarinfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        navbarinfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("blog:navbarinfo:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        navbarinfoService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("blog:navbarinfo:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<NavbarinfoDTO> list = navbarinfoService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "博客导航", list, NavbarinfoExcel.class);
    }

}