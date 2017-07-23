package com.sxshunrj.test;

import javax.naming.InitialContext;
                                                                            
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSender;
import javax.jms.DeliveryMode;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
                                                                            
public class Sender
{
    public static void main(String[] args) throws Exception
    {
       // get the initial context
       InitialContext context = new InitialContext();
                                                               
       // lookup the queue object
       Queue queue = (Queue) context.lookup("queue/queue0");
                                                                           
       // lookup the queue connection factory
       QueueConnectionFactory conFactory = (QueueConnectionFactory) context.lookup ("queue/connectionFactory");
                                                                           
       // create a queue connection
       QueueConnection queConn = conFactory.createQueueConnection();
                                                                           
       // create a queue session
       QueueSession queSession = queConn.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);
                                                                           
       // create a queue sender
       QueueSender queueSender = queSession.createSender(queue);
       queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                                                                           
       // create a simple message to say "Hello World"
       TextMessage message = queSession.createTextMessage("Hello World");
                                                     
       // send the message
        queueSender.send(message);
                                                                          
       // print what we did
       System.out.println("Message Sent: " + message.getText());
                                                                           
       // close the queue connection
       queConn.close();
    }
}