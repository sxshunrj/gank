package com.sxshunrj.test;

import javax.jms.*;
import javax.naming.InitialContext;

public class QueueMessageClient {
         public static void main(String[] args)throws Exception {
                   InitialContext context = new InitialContext();
                   //获取QueueConnectionFactory对象
                   QueueConnectionFactory factory=(QueueConnectionFactory)context.lookup("ConnectionFactory");
                   //创建QueueConnection
                   QueueConnection connection=factory.createQueueConnection();
                   //创建QueueSession对象
                   QueueSession session=connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
                   //获取Destination对象
                   Queue queue =(Queue)context.lookup("queue/myqueue");
                   //创建文本消息
                   TextMessage msg=session.createTextMessage("Hello World --世界,你好");
                   //创建发送者
                   QueueSender sender=session.createSender(queue);
                   //发送消息
                   sender.send(msg);                  
                   //关闭会话
                   session.close();
                   connection.close();
                  
                   System.out.println("消息已发送");       
         }
}