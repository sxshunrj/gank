package com.sxshunrj.test.kafka;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class OutFile extends BaseBasicBolt {
       FileWriter fileWriter = null;
       //在bolt组件运行过程中只会被调用一次
       //     /usr/local/apache-storm-1.1.1/user_files/kafka/
       @Override
       public void prepare(Map stormConf, TopologyContext context) {
              try {
                     fileWriter = new FileWriter("/usr/local/apache-storm-1.1.1/user_files/kafka/"+UUID.randomUUID());
              } catch (IOException e) {
                     throw new RuntimeException(e);
              }
       }

       //该bolt组件的核心处理逻辑
       //每收到一个tuple消息，就会被调用一次
       @Override
       public void execute(Tuple tuple, BasicOutputCollector collector) {
              String data = tuple.getString(0);
              try {
                     fileWriter.write(data);
                     fileWriter.write("\n");
                     fileWriter.flush();
              } catch (IOException e) {
                     throw new RuntimeException(e);
              }
       }
       //本bolt已经不需要发送tuple消息到下一个组件，所以不需要再声明tuple的字段
       @Override
       public void declareOutputFields(OutputFieldsDeclarer arg0) {

       }

 

}