package com.sxshunrj.netty.http.business.handler;

import com.alibaba.fastjson.JSON;
import com.sxshunrj.netty.http.business.param.AParamDto;
import com.sxshunrj.netty.http.common.handler.AbstractBusinessHandler;
import com.sxshunrj.netty.http.common.param.request.RequestParam;
import com.sxshunrj.netty.http.common.param.request.SimpleRequestParam;
import com.sxshunrj.netty.http.util.CommonUtil;
import com.tunion.common.utils.Rsp;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/16 14:39
 * Desc：
 */
public class AqqHandler extends AbstractBusinessHandler<SimpleRequestParam> {

    public int getA1(RequestParam requestParam){
        System.out.println("AqqHandler requestParam:"+ JSON.toJSONString(requestParam));
        AParamDto paramDto = CommonUtil.mapToBean(requestParam.getBusinessParam(), new AParamDto());

        System.out.println("AqqHandler paramDto:"+ JSON.toJSONString(paramDto));
        return 1;
    }

    public Rsp getA2(){
        return new Rsp(true, "getA2");
    }

}
