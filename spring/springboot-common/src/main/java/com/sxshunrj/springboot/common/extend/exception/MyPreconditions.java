package com.sxshunrj.springboot.common.extend.exception;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/11/16 20:12
 * Desc：
 */
public final class MyPreconditions {

    public static void checkArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new BusinessException(errorMessage);
        }
    }

    public static void checkState(boolean expression, String errorMessage) {
        if (!expression) {
            throw new BusinessException(errorMessage);
        }
    }
}
