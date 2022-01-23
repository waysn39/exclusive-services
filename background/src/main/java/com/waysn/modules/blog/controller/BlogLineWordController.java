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
import com.waysn.modules.blog.dto.BlogLineWordDTO;
import com.waysn.modules.blog.excel.BlogLineWordExcel;
import com.waysn.modules.blog.service.BlogLineWordService;
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
* 博客一句话
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-01-23
*/
@RestController
@RequestMapping("blog/bloglineword")
@Api(tags="博客一句话")
public class BlogLineWordController {
    @Autowired
    private BlogLineWordService blogLineWordService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("blog:bloglineword:page")
    public Result<PageData<BlogLineWordDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<BlogLineWordDTO> page = blogLineWordService.page(params);

        return new Result<PageData<BlogLineWordDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("blog:bloglineword:info")
    public Result<BlogLineWordDTO> get(@PathVariable("id") Long id){
        BlogLineWordDTO data = blogLineWordService.get(id);

        return new Result<BlogLineWordDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("blog:bloglineword:save")
    public Result save(@RequestBody BlogLineWordDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        blogLineWordService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("blog:bloglineword:update")
    public Result update(@RequestBody BlogLineWordDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        blogLineWordService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("blog:bloglineword:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        blogLineWordService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("blog:bloglineword:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<BlogLineWordDTO> list = blogLineWordService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "博客一句话", list, BlogLineWordExcel.class);
    }

}