package com.sxshunrj.springboot.common.extend.exception;

import com.sxshunrj.springboot.common.dto.rsp.Error;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/11/16 20:10
 * Desc：
 */
public class BusinessException extends RuntimeException {

    private Error error;

    public BusinessException() {
        super();
    }

    public BusinessException(Error error) {
        super(error.getDesc());
        this.error = error;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Error getError() {
        return error;
    }
}
