package com.waysn.modules.game.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 游戏基础信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class GameBaseInfoExcel {
    @ExcelProperty(value = "游戏标题", index = 0)
    private String gameTitle;
    @ExcelProperty(value = "自定义标题", index = 1)
    private String gameCustomTitle;
    @ExcelProperty(value = "标题关键词", index = 2)
    private String gameTitleKeyword;
    @ExcelProperty(value = "游戏版本号", index = 3)
    private String gameVersion;
    @ExcelProperty(value = "分类id", index = 4)
    private Long classifyId;
    @ExcelProperty(value = "游戏分类名称", index = 5)
    private String classifyName;
    @ExcelProperty(value = "游戏平台", index = 6)
    private Integer gamePlatformType;
    @ExcelProperty(value = "摘要", index = 7)
    private String gameSummaryn;
    @ExcelProperty(value = "游戏介绍", index = 8)
    private String gameInfo;
    @ExcelProperty(value = "游戏关键词", index = 9)
    private String gameKeyWord;
    @ExcelProperty(value = "游戏大小", index = 10)
    private Double gameSize;
    @ExcelProperty(value = "游戏缩略图", index = 11)
    private String gamePicUrl;
    @ExcelProperty(value = "游戏评分", index = 12)
    private String gameMark;
    @ExcelProperty(value = "是否启用", index = 13)
    private Boolean isUsed;
}