package com.waysn.modules.game.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 游戏访问日志表
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-06-30
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class GameAccessLogExcel {
    @ExcelProperty(value = "游戏id", index = 0)
    private Long gameId;
    @ExcelProperty(value = "分类id", index = 1)
    private Long classifyId;
    @ExcelProperty(value = "浏览次数", index = 2)
    private Integer viewCount;
    @ExcelProperty(value = "下载次数", index = 3)
    private Integer downloadCount;
}