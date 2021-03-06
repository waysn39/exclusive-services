package com.waysn.modules.game.controller;

import com.waysn.comm.utils.ConvertUtils;
import com.waysn.comm.utils.Result;
import com.waysn.modules.game.controller.vo.GameClassifyVo;
import com.waysn.modules.game.service.GameClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/get/all/game/classify")
    @ApiOperation("获取所有游戏分类")
    public Result<List<GameClassifyVo>> getAllGameClassify(){
        return new Result<List<GameClassifyVo>>().ok(ConvertUtils.sourceToTarget(gameClassifyService.getAllClassify(), GameClassifyVo.class));
    }

}
