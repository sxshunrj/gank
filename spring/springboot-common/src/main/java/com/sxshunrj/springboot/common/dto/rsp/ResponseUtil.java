package com.sxshunrj.springboot.common.dto.rsp;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/11/15 14:37
 * Desc：
 */
public class ResponseUtil implements Serializable {

    public static Rsp buildRsp(int code) {
        Rsp dto =new Rsp();
        dto.setCode(code);
        dto.setMsg(Error.getDescByCode((short) code));
        dto.setStatus(false);
        return dto;
    }

    public static Rsp buildRsp(Error error) {
        int code = error.getCode();
        Rsp dto =new Rsp();
        dto.setCode(code);
        dto.setMsg(Error.getDescByCode((short) code));
        dto.setStatus(StringUtils.equals(error.name(), Error.success.name()) ? true: false);
        return dto;
    }

    public static Rsp buildRsp(Error error, Object data) {
        Rsp response=buildRsp(error);
        response.setData(data);
        return response;
    }

    public static Rsp buildRsp() {
        return buildRsp(Error.success);
    }

    public static Rsp buildRsp(Object data) {
        return buildRsp(Error.success, data);
    }

    public static Rsp buildRsp(String msg, boolean isMsg) {
        if(!isMsg){
            return buildRsp(msg);
        }
        int code = Error.unknown.getCode();
        Rsp dto =new Rsp();
        dto.setCode(code);
        dto.setMsg(msg);
        dto.setStatus(false);
        return dto;
    }

    public static Rsp buildRsp(boolean status, String msg) {
        int code = Error.system.getCode();
        if(status){
            code = Error.success.getCode();
        }

        Rsp dto =new Rsp();
        dto.setCode(code);
        dto.setMsg(msg);
        dto.setStatus(status);
        return dto;
    }
}
