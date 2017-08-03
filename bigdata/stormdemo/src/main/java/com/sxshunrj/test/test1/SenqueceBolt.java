package com.sxshunrj.test.test1;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

public class SenqueceBolt extends BaseBasicBolt {

    public void execute(Tuple input, BasicOutputCollector collector) {
         String word = (String) input.getValue(0);
         String out = "I'm " + word +  "!";  
         System.out.println("out=" + out);
    }
     
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}