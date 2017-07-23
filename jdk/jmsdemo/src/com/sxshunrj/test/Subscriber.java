package com.sxshunrj.test;

import javax.naming.InitialContext;
import javax.jms.Topic;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
                                                                           
public class Subscriber
{
    public static void main(String[] args) throws Exception
    {
       // get the initial context
       InitialContext ctx = new InitialContext();
                                                                          
       // lookup the topic object
       Topic topic = (Topic) ctx.lookup("topic/topic0");
                                                                          
       // lookup the topic connection factory
       TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.
           lookup("topic/connectionFactory");
                                                                          
       // create a topic connection
       TopicConnection topicConn = connFactory.createTopicConnection();
                                                                          
       // create a topic session
       TopicSession topicSession = topicConn.createTopicSession(false,
           Session.AUTO_ACKNOWLEDGE);
                                                                          
       // create a topic subscriber
       TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
                                                                          
       // start the connection
       topicConn.start();
                                                                          
       // receive the message
       TextMessage message = (TextMessage) topicSubscriber.receive();
                                                                          
       // print the message
       System.out.println("Message received: " + message.getText());
                                                                          
       // close the topic connection
       topicConn.close();
    }
}