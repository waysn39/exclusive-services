package com.waysn.modules.game.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 游戏分类
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-05-16
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class GameClassifyExcel {
    @ExcelProperty(value = "游戏分类名称", index = 0)
    private String classifyName;
    @ExcelProperty(value = "创建时间", index = 1)
    private Date createDate;
    @ExcelProperty(value = "更新时间", index = 2)
    private Date updateDate;
}