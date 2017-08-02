package com.sxshunrj.test;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageSend {
	private static Logger logger = LoggerFactory.getLogger(MessageSend.class);
	
	private final Producer<String, String> producer;  
	
	private String topic;
	
	public MessageSend()
	{
		Properties props = new Properties();  

		//kafka消息主题
		topic="test3";

		//此处配置的是kafka的端口  
        props.put("metadata.broker.list", "namenode1:9092");
  
        //配置value的序列化类  
        props.put("serializer.class", "kafka.serializer.StringEncoder");  
        //配置key的序列化类  
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");  
  
        //request.required.acks  
        //0, which means that the producer never waits for an acknowledgement from the broker (the same behavior as 0.7). This option provides the lowest latency but the weakest durability guarantees (some data will be lost when a server fails).  
        //1, which means that the producer gets an acknowledgement after the leader replica has received the data. This option provides better durability as the client waits until the server acknowledges the request as successful (only messages that were written to the now-dead leader but not yet replicated will be lost).  
        //-1, which means that the producer gets an acknowledgement after all in-sync replicas have received the data. This option provides the best durability, we guarantee that no messages will be lost as long as at least one in sync replica remains.  
        props.put("request.required.acks","0");
  
        producer = new Producer<String, String>(new ProducerConfig(props));  
	}
	
	public boolean sendMessage(String msgBody)
	{
		boolean bRet=false;
		 try {
			producer.send(new KeyedMessage<String, String>(topic, msgBody));
			bRet=true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bRet;
	}
	
	public void stop() {
		if(producer!=null){
			producer.close();
		}
	}

	public static void main(String[] args) {
		MessageSend messageSend = new MessageSend();
		messageSend.sendMessage("{'amount':63.50375137330458,'category':'TOY','order_time':1477415932581,'device':'Other','qty':4,'user':{'id':'bf249f36-f593-4307-b156-240b3094a1c3','age':21,'gender':'Male'},'currency':'USD','country':'CHINA'}");
	}
}
