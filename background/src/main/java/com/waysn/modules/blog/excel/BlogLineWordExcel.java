package com.waysn.modules.blog.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 博客一句话
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-23
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class BlogLineWordExcel {
    @ExcelProperty(value = "一句话", index = 0)
    private String lineWord;
}