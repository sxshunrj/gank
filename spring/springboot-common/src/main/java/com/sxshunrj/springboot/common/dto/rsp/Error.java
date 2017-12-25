package com.sxshunrj.springboot.common.dto.rsp;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/11/15 14:29
 * Desc：所有错误枚举 code为5位正整数
 * <ul>
 *      <li>... ...
 * </ul>
 */
public enum Error {

    success(10000,"成功"),
    system_network(10001,"网络异常"),
    system(10002,"系统异常"),
    unknown(10003,"未知异常"),
    system_business(10004,"业务处理异常"),
    system_http(10004,"http出现异常"),
    param_err(10005,"参数异常"),

    ;

    int code;
    String desc;

    Error(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByCode(int code) {
        for (Error refer : Error.values())
            if (code == refer.getCode())
                return refer.getDesc();
        return null;
    }
}
