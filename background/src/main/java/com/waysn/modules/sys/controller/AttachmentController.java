package com.waysn.modules.sys.controller;

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
import com.waysn.modules.sys.dto.AttachmentDTO;
import com.waysn.modules.sys.excel.AttachmentExcel;
import com.waysn.modules.sys.service.AttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 附件管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-11
 */
@RestController
@RequestMapping("sys/attachment")
@Api(tags = "附件管理")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("sys:attachment:page")
    public Result<PageData<AttachmentDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<AttachmentDTO> page = attachmentService.page(params);

        return new Result<PageData<AttachmentDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:attachment:info")
    public Result<AttachmentDTO> get(@PathVariable("id") Long id) {
        AttachmentDTO data = attachmentService.get(id);

        return new Result<AttachmentDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:attachment:save")
    public Result save(@RequestBody AttachmentDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        attachmentService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:attachment:update")
    public Result update(@RequestBody AttachmentDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        attachmentService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:attachment:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        attachmentService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("sys:attachment:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<AttachmentDTO> list = attachmentService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "附件管理", list, AttachmentExcel.class);
    }

    @ApiOperation(value = "文件上传", tags = "附件接口")
    @PostMapping("upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        return new Result().ok(attachmentService.upload(file));
    }

    @ApiOperation(value = "文件上传", tags = "附件接口")
    @GetMapping("/download/{path}")
    public void download(@PathVariable String path, HttpServletResponse response) throws Exception {
        attachmentService.download(path, response);
    }
}