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
import com.waysn.modules.game.dto.GameInfoDTO;
import com.waysn.modules.game.excel.GameInfoExcel;
import com.waysn.modules.game.service.GameInfoService;
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
* 游戏信息表
*
* @author waysn39 waysn39@hotmail.com
* @since 1.0 2022-05-16
*/
@RestController
@RequestMapping("game/gameinfo")
@Api(tags="游戏信息表")
public class GameInfoController {
    @Autowired
    private GameInfoService gameInfoService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("game:gameinfo:page")
    public Result<PageData<GameInfoDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<GameInfoDTO> page = gameInfoService.page(params);

        return new Result<PageData<GameInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("game:gameinfo:info")
    public Result<GameInfoDTO> get(@PathVariable("id") Long id){
        GameInfoDTO data = gameInfoService.get(id);

        return new Result<GameInfoDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("game:gameinfo:save")
    public Result save(@RequestBody GameInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        gameInfoService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("game:gameinfo:update")
    public Result update(@RequestBody GameInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        gameInfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("game:gameinfo:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        gameInfoService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("game:gameinfo:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<GameInfoDTO> list = gameInfoService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "游戏信息表", list, GameInfoExcel.class);
    }

}