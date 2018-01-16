package com.sxshunrj.netty.http.business.handler;

import com.sxshunrj.netty.http.common.handler.AbstractBusinessHandler;
import com.sxshunrj.netty.http.business.param.BRequestParam;
import com.sxshunrj.netty.http.common.param.request.SimpleRequestParam;
import com.tunion.common.utils.Rsp;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/16 14:39
 * Desc：
 */
public class BqqHandler extends AbstractBusinessHandler<SimpleRequestParam> {

    public int getB(){
        return 3;
    }

}
