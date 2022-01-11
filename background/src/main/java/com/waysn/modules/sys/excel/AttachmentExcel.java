package com.waysn.modules.sys.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.util.Date;

/**
 * 附件管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-11
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class AttachmentExcel {
    @ExcelProperty(value = "附件名称", index = 0)
    private String attachName;
    @ExcelProperty(value = "路径", index = 1)
    private String attachPath;
    @ExcelProperty(value = "数据长度", index = 2)
    private Long attachLength;
    @ExcelProperty(value = "后缀", index = 3)
    private String attachExt;
}