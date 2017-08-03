package com.sxshunrj.test.test2;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

import java.io.FileWriter;

import java.io.IOException;

import java.util.Map;

import java.util.UUID;

public class SuffixBolt extends BaseBasicBolt {
       FileWriter fileWriter = null;
       //在bolt组件运行过程中只会被调用一次
       @Override
       public void prepare(Map stormConf, TopologyContext context) {
              try {
                     fileWriter = new FileWriter("/usr/local/apache-storm-1.1.1/user_files/"+UUID.randomUUID());
              } catch (IOException e) {
                     throw new RuntimeException(e);
              }
       }

       //该bolt组件的核心处理逻辑
       //每收到一个tuple消息，就会被调用一次
       @Override
       public void execute(Tuple tuple, BasicOutputCollector collector) {
              //先拿到上一个组件发送过来的商品名称
              String upper_name = tuple.getString(0);
              String suffix_name = upper_name + "_itisok";

              //为上一个组件发送过来的商品名称添加后缀
              try {
                     fileWriter.write(suffix_name);
                     fileWriter.write("\n");
                     fileWriter.flush();

                     System.out.println("========suffix_name:"+suffix_name);
              } catch (IOException e) {
                     throw new RuntimeException(e);
              }finally {
                     try {
                            fileWriter.close();
                     } catch (IOException e) {
                            e.printStackTrace();
                     }
              }
       }
       //本bolt已经不需要发送tuple消息到下一个组件，所以不需要再声明tuple的字段
       @Override
       public void declareOutputFields(OutputFieldsDeclarer arg0) {

       }

 

}