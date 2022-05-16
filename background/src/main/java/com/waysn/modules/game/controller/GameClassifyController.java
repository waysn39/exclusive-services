package com.waysn.modules.game.controller;

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
import com.waysn.modules.game.dto.GameClassifyDTO;
import com.waysn.modules.game.excel.GameClassifyExcel;
import com.waysn.modules.game.service.GameClassifyService;
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
* 游戏分类
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-05-16
*/
@RestController
@RequestMapping("game/gameclassify")
@Api(tags="游戏分类")
public class GameClassifyController {
    @Autowired
    private GameClassifyService gameClassifyService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("game:gameclassify:page")
    public Result<PageData<GameClassifyDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<GameClassifyDTO> page = gameClassifyService.page(params);

        return new Result<PageData<GameClassifyDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("game:gameclassify:info")
    public Result<GameClassifyDTO> get(@PathVariable("id") Long id){
        GameClassifyDTO data = gameClassifyService.get(id);

        return new Result<GameClassifyDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("game:gameclassify:save")
    public Result save(@RequestBody GameClassifyDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        gameClassifyService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("game:gameclassify:update")
    public Result update(@RequestBody GameClassifyDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        gameClassifyService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("game:gameclassify:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        gameClassifyService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("game:gameclassify:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<GameClassifyDTO> list = gameClassifyService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "游戏分类", list, GameClassifyExcel.class);
    }

}