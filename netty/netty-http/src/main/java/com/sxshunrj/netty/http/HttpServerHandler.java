package com.sxshunrj.netty.http;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import com.alibaba.fastjson.JSON;
import com.google.common.net.MediaType;
import com.sxshunrj.netty.http.business.handler.CglibProxy;
import com.sxshunrj.netty.http.common.handler.AbstractBusinessHandler;
import com.sxshunrj.netty.http.common.param.request.RequestParam;
import com.sxshunrj.netty.http.business.handler.*;
import com.sxshunrj.netty.http.util.CommonUtil;
import com.tunion.common.utils.Rsp;
import com.tunion.common.utils.exception.BusinessException;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);
    private AbstractBusinessHandler businessHandler;
    private RequestParam requestParam = new RequestParam();
    private CglibProxy cglibProxy = new CglibProxy();
    public static final String HANDLERPREFIX = "com.sxshunrj.netty.http.business.handler.";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            logger.info("HttpRequest jsonstr:"+JSON.toJSONString(request));

            String uriStr = request.uri();
            // uriStr     projectName/clazzName/methodName
            this.parseRequestMethod(uriStr, requestParam);
        }
        if (msg instanceof HttpContent) {
            logger.info("HttpContent jsonstr:"+JSON.toJSONString(msg));

            try {
                HttpContent httpContent = (HttpContent) msg;
                String requestContentStr = httpContent.content().toString(CharsetUtil.UTF_8);

                RequestParam businessRequestParam = CommonUtil.jsonToBean(requestContentStr, RequestParam.class);
                requestParam.setAppId(businessRequestParam.getAppId());
                requestParam.setBusinessParam(businessRequestParam.getBusinessParam());

                Rsp rsp = businessHandler.handleByMethod(requestParam);
                response(rsp, ctx);
            }catch (Exception e){
                Rsp rsp = new Rsp(false, "系统异常");
                if(e instanceof BusinessException){
                    rsp.setMsg(e.getMessage());
                }else{
                    e.printStackTrace();
                }
                response(rsp, ctx);
            }finally {
                ctx.close();
            }
        }
    }


    private void parseRequestMethod(String uriStr, RequestParam requestParam){
        try {

            String[] ps = uriStr.split("/");
            requestParam.setClazzName(ps[1]);
            requestParam.setMethodName(ps[2]);

            String clazzAllName = HANDLERPREFIX+ CommonUtil.captureName(ps[1])+"Handler";
            System.out.println("clazzAllName:"+clazzAllName);
            businessHandler = (AbstractBusinessHandler) cglibProxy.getProxy(Class.forName(clazzAllName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void response(Rsp rsp, ChannelHandlerContext ctx){
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(JSON.toJSONString(rsp).getBytes()));

        response.headers().set(CONTENT_TYPE, MediaType.JSON_UTF_8);
        response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
        response.headers().set(CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        ctx.write(response);
        ctx.flush();
        logger.info("rsp:"+JSON.toJSONString(rsp));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}