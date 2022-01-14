package com.waysn.modules.blog.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 博客图片管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-13
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class BlogImageExcel {
    @ExcelProperty(value = "图片类型", index = 0)
    private Integer imageType;
    @ExcelProperty(value = "图片路径", index = 1)
    private String imagePath;
}