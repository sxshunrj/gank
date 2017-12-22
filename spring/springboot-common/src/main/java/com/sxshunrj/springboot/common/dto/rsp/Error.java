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

    user_not_exist(20001,"用户不存在"),
    user_loginpassword_wrong(20002, "登录密码错误"),
    user_mobile_exist(20003, "该手机号码已存在"),
    user_authcode_sended(20004, "验证码已发送"),
    user_authcode_wrong(20005, "验证码错误"),
    user_notlogin(20006, "用户未登录"),

    account_not_exist(30001,"账户不存在"),

    trade_paypassword_wrong(40001,"支付密码错误"),
    trade_notpaytoself(40002,"不能给自己转账"),
    trade_type_wrong(40003,"不支持的交易类型"),
    trade_qr_overtime(40005,"二维码超时"),

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
