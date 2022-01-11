package com.waysn.modules.blog.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jinyiming
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class NavbarinfoVo {
    /**
     * 导航名称
     */
    @JSONField(name = "text")
    private String navbarName;
    /**
     * 连接
     */
    @JSONField(name = "link")
    private String navbarLink;
    /**
     * 图标
     */
    @JSONField(name = "iconClass")
    private String navbarIconClass;
}
