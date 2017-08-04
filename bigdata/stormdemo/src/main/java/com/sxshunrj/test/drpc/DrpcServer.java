package com.sxshunrj.test.drpc;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.StormSubmitter;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class DrpcServer extends BaseBasicBolt {
 public static void main(String[] args) throws AlreadyAliveException,
         InvalidTopologyException, AuthorizationException {
  //function:客户端调用的func name
  LinearDRPCTopologyBuilder builder = new LinearDRPCTopologyBuilder("hellodrpcserver");
  builder.addBolt(new DrpcServer(), 3);
  
  Config config = new Config();
  config.setDebug(true);
  if (args == null || args.length == 0) {
   LocalDRPC drpc = new LocalDRPC();
   LocalCluster cluster = new LocalCluster();
   
   cluster.submitTopology("localdrpcserver", config,
     builder.createLocalTopology(drpc));
   for (String word : new String[] { "hello", "goodbye" }) {
    System.err.println("Result for " + word + ": " + drpc.execute("exclamation", word));
   }
   cluster.shutdown();
   drpc.shutdown();
  } else {
   // conf.setNumWorkers(3);
   //ui显示的drpc topology名称
   StormSubmitter.submitTopology("drpcserver", config,
     builder.createRemoteTopology());
  }
 }
 public void execute(Tuple tuple, BasicOutputCollector collector) {
  String input = tuple.getString(1);
  collector.emit(new Values(tuple.getValue(0), input + "$$$$$$$$$$$$$"));
 }
 public void declareOutputFields(OutputFieldsDeclarer declarer) {
  declarer.declare(new Fields("id", "result"));
 }
}