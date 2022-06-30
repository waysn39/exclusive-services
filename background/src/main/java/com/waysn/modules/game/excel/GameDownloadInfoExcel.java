package com.waysn.modules.game.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 游戏下载信息表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class GameDownloadInfoExcel {
    @ExcelProperty(value = "游戏id", index = 0)
    private Long gameId;
    @ExcelProperty(value = "下载链接", index = 1)
    private String gameDownloadUrl;
    @ExcelProperty(value = "安卓链接", index = 2)
    private String gameDownloadAndroidUrl;
    @ExcelProperty(value = "ios链接", index = 3)
    private String gameDownloadIosUrl;
    @ExcelProperty(value = "下载提示", index = 4)
    private String gameDownloadTip;
}