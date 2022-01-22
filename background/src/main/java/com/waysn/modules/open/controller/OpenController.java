package com.waysn.modules.open.controller;

import com.alibaba.fastjson.JSON;
import com.waysn.comm.utils.Result;
import com.waysn.comm.utils.StringUtils;
import com.waysn.modules.blog.entity.NavbarinfoEntity;
import com.waysn.modules.blog.enums.BlogImageEnum;
import com.waysn.modules.blog.service.BlogImageService;
import com.waysn.modules.blog.service.NavbarinfoService;
import com.waysn.modules.blog.vo.NavbarinfoVo;
import com.waysn.modules.sys.service.AttachmentService;
import io.minio.errors.MinioException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("open")
@Api(tags = "OpenController")
public class OpenController {
    @Resource
    private NavbarinfoService navbarinfoService;
    @Resource
    private BlogImageService blogImageService;

    @Resource
    private AttachmentService attachmentService;

    @GetMapping("/get/blog/navbar")
    @ApiOperation("获取博客导航栏信息")
    public Result getBlogNavbar() {
        List<NavbarinfoEntity> data = navbarinfoService.getAllNavbarInfoByParent("root");
        List<NavbarinfoVo> navbarinfoVoList = new ArrayList<>();
        for (NavbarinfoEntity item : data) {
            NavbarinfoVo navbarinfoVo = mapNavbarInfoVo(item);
            getChildNavbar(item.getNavbarCode(), navbarinfoVo);
            navbarinfoVoList.add(navbarinfoVo);
        }
        return new Result().ok(JSON.parse(JSON.toJSONString(navbarinfoVoList)));
    }

    @GetMapping("/get/background/image")
    @ApiOperation("获取博客背景图")
    public Result getBackgroundImg() throws MinioException {
        List<String> paths = blogImageService.getImgByType(BlogImageEnum.PC_BACKGROUND);
        return new Result().ok(attachmentService.getShareUrls(paths));
    }

    @GetMapping("/get/logo")
    @ApiOperation("获取博客Logo")
    public Result getLogo() throws MinioException {
        List<String> paths = blogImageService.getImgByType(BlogImageEnum.LOGO);
        return new Result().ok(attachmentService.getShareUrls(paths));
    }

    @GetMapping("/get/head")
    @ApiOperation("获取博客头像")
    public Result getHead() throws MinioException {
        List<String> paths = blogImageService.getImgByType(BlogImageEnum.HEAD);
        return new Result().ok(attachmentService.getShareUrls(paths));
    }

    @GetMapping("/get/word/head/img")
    @ApiOperation("获取文字头部图片")
    public Result getWordHeadImg() throws MinioException {
        List<String> paths = blogImageService.getImgByType(BlogImageEnum.WORD_HEAD);
        return new Result().ok(attachmentService.getShareUrls(paths));
    }

    private NavbarinfoVo mapNavbarInfoVo(NavbarinfoEntity item) {
        NavbarinfoVo navbarinfoVo = new NavbarinfoVo();
        navbarinfoVo.setNavbarName(item.getNavbarName());
        navbarinfoVo.setNavbarLink(item.getNavbarLink());
        if (StringUtils.isNullOrEmpty(item.getNavbarLink())) {
            navbarinfoVo.setNavbarLink(null);
        }
        navbarinfoVo.setNavbarIconClass(item.getNavbarIconClass());
        return navbarinfoVo;
    }

    private void getChildNavbar(String parentCode, NavbarinfoVo currentItem) {
        List<NavbarinfoEntity> childs = navbarinfoService.getAllNavbarInfoByParent(parentCode);
        if (childs.size() > 0) {
            List<NavbarinfoVo> navbarinfoVoList = new ArrayList<>();
            for (NavbarinfoEntity item : childs) {
                NavbarinfoVo navbarinfoVo = mapNavbarInfoVo(item);
                getChildNavbar(item.getNavbarCode(), navbarinfoVo);
                navbarinfoVoList.add(navbarinfoVo);
            }
            currentItem.setChildren(navbarinfoVoList);
        } else {
            currentItem.setChildren(null);
        }
    }
}
