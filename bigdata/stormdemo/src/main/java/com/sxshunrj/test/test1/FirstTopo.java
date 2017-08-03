package com.sxshunrj.test.test1;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

public class FirstTopo {
     
    public static void main(String[] args) throws Exception {  
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("spout", new RandomSpout());  
        builder.setBolt("bolt", new SenqueceBolt()).shuffleGrouping("spout"); 
        Config conf = new Config();
//        conf.setDebug(true);
        if (args != null && args.length > 0) {  
            conf.setNumWorkers(3);  
            StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
        } else {  
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("firstTopo", conf, builder.createTopology());  
            Utils.sleep(3000);
            cluster.killTopology("firstTopo");  
            cluster.shutdown();  
        }  
    }  
}