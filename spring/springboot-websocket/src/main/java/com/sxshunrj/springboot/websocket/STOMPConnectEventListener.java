package com.sxshunrj.springboot.websocket;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * STOMP监听类
 * 用于session注册 以及key值获取
 */
public class STOMPConnectEventListener  implements ApplicationListener<SessionConnectEvent> {

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        //login get from browser
        String agentId = sha.getNativeHeader("login").get(0);
        String sessionId = sha.getSessionId();

        System.out.println("STOMPConnectEventListener-->agentId:"+agentId+",sessionId:"+sessionId);
        System.out.println("stomp Subscribe : "+ sha.getMessageHeaders());
    }
}