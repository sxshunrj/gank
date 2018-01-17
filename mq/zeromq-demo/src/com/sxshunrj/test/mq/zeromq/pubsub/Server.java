package com.sxshunrj.test.mq.zeromq.pubsub;

import org.zeromq.ZMQ;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/22 16:15
 * Desc：
 */
public class Server {

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);  //创创建包含一个I/O线程的context
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);   //创建一个publisher类型的socket，他可以向所有订阅的subscriber广播数据

        publisher.bind("tcp://*:5555");  //将当前publisher绑定到5555端口上，可以接受subscriber的订阅

        while (!Thread.currentThread ().isInterrupted ()) {
            String message = "qwertyui hello";  //最开始可以理解为pub的channel，subscribe需要订阅fjs这个channel才能接收到消息
            publisher.send(message.getBytes());
        }

        publisher.close();
        context.term();
    }

}
