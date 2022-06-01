package com.waysn.modules.game.controller;

import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.utils.ConvertUtils;
import com.waysn.comm.utils.Result;
import com.waysn.modules.game.controller.vo.GameClassifyVo;
import com.waysn.modules.game.controller.vo.GameInfoVo;
import com.waysn.modules.game.dto.GameInfoDTO;
import com.waysn.modules.game.service.GameClassifyService;
import com.waysn.modules.game.service.GameInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: jinyiming
 * @Date: 2022/5/23
 **/
@RestController
@RequestMapping("open/game")
@Api(tags="游戏前端展示接口")
public class OpenGameController {
    @Resource
    private GameClassifyService gameClassifyService;

    @Resource
    private GameInfoService gameInfoService;

    @GetMapping("/get/all/game/classify")
    @ApiOperation("获取所有游戏分类")
    public Result<List<GameClassifyVo>> getAllGameClassify(){
        return new Result<List<GameClassifyVo>>().ok(ConvertUtils.sourceToTarget(gameClassifyService.getAllClassify(), GameClassifyVo.class));
    }

    @GetMapping("/get/game/info/page")
    @ApiOperation("获取所有游戏分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<GameInfoDTO>> getGameInfoPage(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<GameInfoDTO> page = gameInfoService.page(params);
        return new Result<PageData<GameInfoDTO>>().ok(page);
    }

    @GetMapping("/get/game/info/{id}")
    @ApiOperation("根据ID获取游戏")
    public Result<GameInfoVo> getGameInfoById(@PathVariable("id") Long id){
        GameInfoVo data = ConvertUtils.sourceToTarget(gameInfoService.get(id), GameInfoVo.class);
        return new Result<GameInfoVo>().ok(data);
    }

}
