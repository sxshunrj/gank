package com.sxshunrj.springboot.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;  
import org.springframework.web.socket.WebSocketHandler;  
import org.springframework.web.socket.WebSocketMessage;  
import org.springframework.web.socket.WebSocketSession;  
  
//extending either TextWebSocketHandler or BinaryWebSocketHandler
public class MyHandler implements WebSocketHandler {  

    @Override  
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Connection closed..."+session.getRemoteAddress().toString());
    }
  
    @Override  
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connection established..."+session.getRemoteAddress().toString());
    }  
  
    @Override  
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
         try {
             System.out.println("Req: "+message.getPayload());
            TextMessage returnMessage = new TextMessage(message.getPayload()
                      + " received at server");
             session.sendMessage(returnMessage);
        } catch (Exception e) {  
            e.printStackTrace();  
        }    
    }  
  
    @Override  
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        if(session.isOpen()){
            session.close();
        }  
        System.out.println(throwable.toString());
        System.out.println("WS connection error,close...");  
    }  
  
    @Override  
    public boolean supportsPartialMessages() {  
        return false;
    }  
}