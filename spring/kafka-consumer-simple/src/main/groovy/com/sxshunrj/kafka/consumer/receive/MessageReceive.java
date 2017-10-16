package com.sxshunrj.kafka.consumer.receive;

import com.sxshunrj.kafka.consumer.dto.MsgDto;
import com.sxshunrj.kafka.consumer.service.CallbackBusinessService;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MessageReceive extends Thread{
	
	private final ConsumerConnector consumer;
    private String topic;
    private String groupId;

	private CallbackBusinessService callbackBusinessService;

    public MessageReceive(String topic, String groupId) {
		this.topic = topic;
		this.groupId = groupId;
        consumer =kafka.consumer.Consumer    
                .createJavaConsumerConnector(createConsumerConfig());
    }

	public MessageReceive setCallbackBusinessService(CallbackBusinessService callbackBusinessService) {
		this.callbackBusinessService = callbackBusinessService;
		return this;
	}

	private ConsumerConfig createConsumerConfig() {
	    
		Properties props = new Properties();  
	    props.put("zookeeper.connect", "192.168.10.14:2181");
	    
	    //group 代表一个消费组  
	    props.put("group.id", this.groupId);

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

	    System.out.println("*******************"+topic+"*********Results******");
	    while(true){
	        if(it.hasNext()){
				MessageAndMetadata<byte[], byte[]> next = it.next();

				String topic = next.topic();
				String msgContent= new String(next.message());
				MsgDto msgDto = new MsgDto(null, topic, msgContent);

				this.callbackBusinessService.callback(msgDto, topic, this.groupId);
	        }
	    }
	}
	
}
