/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.exception;

import com.waysn.comm.exception.ErrorCode;
import com.waysn.comm.exception.ServicesException;
import com.waysn.comm.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author jinyiming waysn39@hotmail.com
 * @since 1.0.0
 */
@RestControllerAdvice
public class RenExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RenExceptionHandler.class);

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(ServicesException.class)
    public Result handleRenException(ServicesException ex) {
        Result result = new Result();
        result.error(ex.getCode(), ex.getMsg());

        return result;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException ex) {
        Result result = new Result();
        result.error(ErrorCode.DB_RECORD_EXISTS);

        return result;
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);

        return new Result().error();
    }
}