package com.sxshunrj.test.mq.zeromq.pushpull;

import org.zeromq.ZMQ;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/22 16:15
 * Desc：
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket push  = context.socket(ZMQ.PUSH);
        push.bind("ipc://fjs");

        for (int i = 0; i < 10000000; i++) {
            push.send("hello".getBytes());
        }
        push.close();
        context.term();
    }

}
