package com.sxshunrj.test.mq.zeromq.pubsub;

import org.zeromq.ZMQ;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/22 16:21
 * Desc：
 */
public class Client {
    public static void main(String[] args)  {
        for (int j = 0; j < 100; j++) {
            new Thread(new Runnable(){

                public void run() {
                    ZMQ.Context context = ZMQ.context(1);  //创建1个I/O线程的上下文
                    ZMQ.Socket subscriber = context.socket(ZMQ.SUB);     //创建一个sub类型，也就是subscriber类型的socket
                    subscriber.connect("tcp://127.0.0.1:5555");    //与在5555端口监听的publisher建立连接
                    subscriber.subscribe("qwe".getBytes());     //订阅fjs这个channel

                    for (int i = 0; i < 100; i++) {
                        byte[] message = subscriber.recv();  //接收publisher发送过来的消息
                        System.out.println("receive : " + new String(message));
                    }
                    subscriber.close();
                    context.term();
                }

            }).start();
        }
    }

}
