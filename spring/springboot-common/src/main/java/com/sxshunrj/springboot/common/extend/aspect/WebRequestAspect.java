package com.sxshunrj.springboot.common.extend.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/11/10 15:05
 * Desc：Controller 方法请求拦截器，主要是为了打印请求和返回的日志信息
 */
@Aspect
@Component
@Order(value = 0)//value越大 优先级越低
public class WebRequestAspect {

    public static ThreadLocal<ReqLog> WEBREQTHREADLOCAL = new ThreadLocal<>();

    private static final Logger logger = LoggerFactory.getLogger(WebRequestAspect.class);

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    @Pointcut("execution(* com.sxshunrj.springboot.common.controller..*.*(..))")
    public void controllerMethodPointcut(){}

    /**
     * 拦截器具体实现
     */
    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint point) throws Throwable {

        requestSessionInfo();

        long logId = System.currentTimeMillis();
        long startTime = System.currentTimeMillis();
        WEBREQTHREADLOCAL.set(new ReqLog(logId, startTime));

        Class<?> targetClass=point.getTarget().getClass();
        String className=targetClass.getSimpleName();
        String methodName = point.getSignature().getName();
        Object[] params = null;//point.getArgs();

        logger.info("[{}]，请求开始，类：[{}]，方法：[{}]，参数：[{}]",
                new Object[]{logId,  className ,methodName, JSON.toJSONString(params)});

        Object result = point.proceed();

        long costMs = System.currentTimeMillis() - startTime;
        logger.info("[{}]，接口[{}]请求结束，正常返回，耗时：[{}]ms，返回：[{}]",
                new Object[]{logId, className+"-"+methodName, costMs , JSON.toJSONString(result)});

        return result;
    }

    @AfterThrowing(pointcut = "controllerMethodPointcut()", throwing = "ex")
    public void afterThrowing(Throwable ex) throws Throwable {
        logger.info("====AfterThrowing 交给 SpringExceptionHandler 处理");
        throw ex;// 交给 SpringExceptionHandler 处理
    }


    public void requestSessionInfo(){
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
//        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if(str.length() > 0) {
            logger.info("###请求的参数信息为requestSessionInfo："+str);
        }
    }

    public static class ReqLog{
        public long logId;
        public long startTime;

        public ReqLog(long logId, long startTime) {
            this.logId = logId;
            this.startTime = startTime;
        }
    }
}
