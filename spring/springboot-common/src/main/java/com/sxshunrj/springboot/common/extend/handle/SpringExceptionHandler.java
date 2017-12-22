package com.sxshunrj.springboot.common.extend.handle;

import com.alibaba.fastjson.JSON;
import com.sxshunrj.springboot.common.dto.rsp.ResponseUtil;
import com.sxshunrj.springboot.common.dto.rsp.Rsp;
import com.sxshunrj.springboot.common.extend.aspect.WebRequestAspect;
import com.sxshunrj.springboot.common.extend.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/11/6 12:43
 * Desc：处理所有Controller抛出的异常
 */
@RestControllerAdvice
public class SpringExceptionHandler{

    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    public Rsp handleOtherExceptions(Exception ex) {
        logger.info("===SpringExceptionHandler......");
        ex.printStackTrace();
        Rsp rsp = ResponseUtil.buildRsp(false, "系统异常");

        WebRequestAspect.ReqLog reqLog =WebRequestAspect.WEBREQTHREADLOCAL.get();
        if(null == reqLog){
            return rsp;
        }

        if(ex instanceof BusinessException){
            rsp =  ResponseUtil.buildRsp(false, ex.getMessage());
        }

        long costMs = System.currentTimeMillis() - reqLog.startTime;
        logger.info("[{}]，接口请求结束，出现异常，耗时：[{}]ms，返回：[{}]",
                new Object[]{reqLog.logId, costMs , JSON.toJSONString(rsp)});

        WebRequestAspect.WEBREQTHREADLOCAL.remove();
        return rsp;
    }

}
