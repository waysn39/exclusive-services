package com.waysn.modules.blog.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 博客导航
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-09
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class NavbarinfoExcel {
    @ExcelProperty(value = "id", index = 0)
    private Long id;
    @ExcelProperty(value = "节点编码", index = 1)
    private String navbarCode;
    @ExcelProperty(value = "导航名称", index = 2)
    private String navbarName;
    @ExcelProperty(value = "连接", index = 3)
    private String navbarLink;
}