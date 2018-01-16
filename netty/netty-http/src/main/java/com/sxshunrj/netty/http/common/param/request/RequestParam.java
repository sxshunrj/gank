package com.sxshunrj.netty.http.common.param.request;

import com.google.common.collect.Maps;
import com.sxshunrj.netty.http.common.param.Param;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/16 14:39
 * Desc：
 */
public class RequestParam extends Param {
    private String appId;

    private String clazzName;
    private String methodName;

    private Map<String, Object> businessParam = Maps.newHashMap();

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Map<String, Object> getBusinessParam() {
        return businessParam;
    }

    public void setBusinessParam(Map<String, Object> businessParam) {
        this.businessParam = businessParam;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
