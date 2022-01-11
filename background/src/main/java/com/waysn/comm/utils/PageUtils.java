/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */
package com.waysn.comm.utils;

import com.waysn.comm.constant.Constant;

import java.util.Map;

/**
 * 分页工具
 *
 * @author jinyiming waysn39@hotmail.com
 */
public class PageUtils {

    /**
     * 获取分页起始位置
     */
    public static int getPageOffset(Map<String, Object> params) {
        int curPage = 1;
        int limit = 10;
        if (params.get(Constant.PAGE) != null) {
            curPage = Integer.parseInt((String) params.get(Constant.PAGE));
        }
        if (params.get(Constant.LIMIT) != null) {
            limit = Integer.parseInt((String) params.get(Constant.LIMIT));
        }

        return (curPage - 1) * limit;
    }

    /**
     * 获取分页条数
     */
    public static int getPageLimit(Map<String, Object> params) {
        if (params.get(Constant.LIMIT) != null) {
            return Integer.parseInt((String) params.get(Constant.LIMIT));
        } else {
            return 10;
        }
    }
}
