package com.waysn.modules.game.controller.vo;

import liquibase.pro.packaged.S;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: jinyiming
 * @Date: 2022/6/1
 **/
@Data
@Accessors(chain = true)
public class SelectDataVo {
    private String label;
    private String value;
}
