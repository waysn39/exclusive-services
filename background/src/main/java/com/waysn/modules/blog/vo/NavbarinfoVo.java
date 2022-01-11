package com.waysn.modules.blog.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jinyiming
 */
@Data
@EqualsAndHashCode(callSuper = false)
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
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String navbarLink;
    /**
     * 图标
     */
    @JSONField(name = "iconClass")
    private String navbarIconClass;

    @JSONField(name = "children")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<NavbarinfoVo> children;
}
