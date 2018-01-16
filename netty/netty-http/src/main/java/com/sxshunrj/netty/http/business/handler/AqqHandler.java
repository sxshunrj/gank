package com.sxshunrj.netty.http.business.handler;

import com.alibaba.fastjson.JSON;
import com.sxshunrj.netty.http.common.handler.AbstractBusinessHandler;
import com.sxshunrj.netty.http.business.param.ARequestParam;
import com.sxshunrj.netty.http.common.param.request.RequestParam;
import com.sxshunrj.netty.http.common.param.request.SimpleRequestParam;
import com.tunion.common.utils.Rsp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/16 14:39
 * Desc：
 */
public class AqqHandler extends AbstractBusinessHandler<SimpleRequestParam> {

    public int getA(RequestParam requestParam){
        System.out.println("AqqHandler requestParam:"+ JSON.toJSONString(requestParam));
        return 1;
    }

}
