package com.sxshunrj.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class MessageReceive extends Thread{
	
	private final ConsumerConnector consumer;
    private String topic;  
    
    public MessageReceive() {
        consumer =kafka.consumer.Consumer    
                .createJavaConsumerConnector(createConsumerConfig());    
        this.topic = "test10";
    }  

	private static ConsumerConfig createConsumerConfig() {
	    
		Properties props = new Properties();  
	    props.put("zookeeper.connect", "192.168.10.14:2181");
	    
	    //group 代表一个消费组  
	    props.put("group.id", "group1");

	    //zk连接超时  
	    props.put("zookeeper.session.timeout.ms", "100");
	    props.put("zookeeper.sync.time.ms", "100");
	    props.put("auto.commit.interval.ms", "100");
	    props.put("auto.offset.reset", "largest");
	    //序列化类  
	    props.put("serializer.class", "kafka.serializer.StringEncoder");  
	    
	    //解决重试次数
	    props.put("rebalance.max.retries", "5");
	    props.put("rebalance.backoff.ms", "10");
		  
	    return new ConsumerConfig(props);    
	}  
	
	public void run(){    
	    Map<String,Integer> topickMap = new HashMap<String, Integer>();    
	    topickMap.put(topic, 1);
	    Map<String, List<KafkaStream<byte[],byte[]>>>  streamMap =consumer.createMessageStreams(topickMap);
	    KafkaStream<byte[],byte[]> stream = streamMap.get(topic).get(0);
	    ConsumerIterator<byte[],byte[]> it = stream.iterator();

	    System.out.println("****************************Results****************************");
	    while(true){
	        if(it.hasNext()){
	            String msgContent= new String(it.next().message());
				System.out.println("Receive Message Data:" +msgContent);
	        }
	        try {    
	            Thread.sleep(1000);    
	        } catch (InterruptedException e) {    
	            e.printStackTrace();    
	        }    
	    }    
	}
	
}
