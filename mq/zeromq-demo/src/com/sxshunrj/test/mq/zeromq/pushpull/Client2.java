package com.sxshunrj.test.mq.zeromq.pushpull;

import org.zeromq.ZMQ;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/22 16:21
 * Desc：
 */
public class Client {
    public static void main(String[] args)  {
        final AtomicInteger number = new AtomicInteger(0);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable(){
                private int here = 0;
                public void run() {
                    ZMQ.Context context = ZMQ.context(1);
                    ZMQ.Socket pull = context.socket(ZMQ.PULL);
                    pull.connect("ipc://fjs");
                    while (true) {
                        String message = new String(pull.recv());
                        int now = number.incrementAndGet();
                        here++;
                        if (now % 1000000 == 0) {
                            System.out.println(now + "  here is : " + here);
                        }
                    }
                }

            }).start();

        }
    }

}
