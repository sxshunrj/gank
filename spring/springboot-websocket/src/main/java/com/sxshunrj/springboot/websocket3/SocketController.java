package com.sxshunrj.springboot.websocket3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;

@RestController
public class SocketController {

    @Autowired
    MyHandler handler;

    @RequestMapping("/login/{userId}")
    public boolean login(HttpSession session, @PathVariable("userId") Integer userId) {
        System.out.println("登录接口,userId="+userId);
        session.setAttribute("userId", userId);

        if(userId == 100){
            handler.forceExit(1);
        }

        return true;
    }

    @RequestMapping("/message")
    public boolean sendMessage(Integer touserid, String message) {
        if(null == touserid && StringUtils.isEmpty(message)){
            return false;
        }
        if(null == touserid){
            return handler.sendMessageToAllUsers(new TextMessage(message));
        }
        return handler.sendMessageToUser(touserid, new TextMessage(message));
    }

}