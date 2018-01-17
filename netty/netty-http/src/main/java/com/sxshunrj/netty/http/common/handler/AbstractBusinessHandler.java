package com.sxshunrj.netty.http.common.handler;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sxshunrj.netty.http.HttpServerHandler;
import com.sxshunrj.netty.http.common.param.request.RequestParam;
import com.tunion.common.utils.Rsp;
import com.tunion.common.utils.StringUtils;
import com.tunion.common.utils.exception.BusinessException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/16 14:38
 * Desc：
 */
public abstract class AbstractBusinessHandler<T extends RequestParam> {

    private List<String> appIds = Lists.newArrayList("111", "222", "333");

    public Rsp checkAppId(RequestParam requestParam){
        return new Rsp(appIds.contains(requestParam.getAppId()));
    }

    public Rsp handle(T requestParam){
        throw new RuntimeException("The subclass implementation");
    }

    public Rsp handleByMethod(T requestParam) throws Exception {
        Method[] methods = getMethods();
        String requestMethodName = requestParam.getMethodName();

        for (Method method : methods){
            if(null!=method && StringUtils.isNotBlank(method.getName())
                    && method.getName().equals(requestMethodName)){
                try {
                    int paramCount = method.getParameterCount();
                    Object methodRet = null;

                    if(0 == paramCount){
                        methodRet = method.invoke(this);
                    }else if(1 == paramCount && method.getParameterTypes()[0].getName().equals(RequestParam.class.getName())){
                        methodRet = method.invoke(this, requestParam);
                    }else{
                        throw new BusinessException("request param error");
                    }
                    System.out.println("invoke method:"+JSON.toJSONString(method)+",methodRet:"+JSON.toJSONString(methodRet));

                    if(null == methodRet){
                        return new Rsp(true);
                    }
                    if(methodRet instanceof Rsp){
                        return (Rsp)methodRet;
                    }else {
                        return new Rsp(true, methodRet);
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        throw new BusinessException("No corresponding processing method was found");
    }

    private Method[] getMethods(){
        Method[] methods = this.getClass().getMethods();
        Method[] methodsRet = new Method[methods.length];
        for(int i=0; i<methods.length; i++){
            String declaringClass = methods[i].getDeclaringClass().getName();
            if(declaringClass.contains(HttpServerHandler.HANDLERPREFIX)){
                methodsRet[i] = methods[i];
            }
        }
        return methodsRet;
    }

}
