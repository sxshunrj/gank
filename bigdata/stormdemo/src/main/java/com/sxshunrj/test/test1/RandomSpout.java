package com.sxshunrj.test.test1;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;
import java.util.Random;
public class RandomSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;
    private static String[] words = {"happy","excited","angry"};
     
    public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
        this.collector = arg2;
    }
     
    public void nextTuple() {
        String word = words[new Random().nextInt(words.length)];
        collector.emit(new Values(word));
    }
     
    public void declareOutputFields(OutputFieldsDeclarer arg0) {
        arg0.declare(new Fields("randomstring"));
    }
}