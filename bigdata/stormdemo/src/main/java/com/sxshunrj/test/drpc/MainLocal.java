package com.sxshunrj.test.drpc;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.StormSubmitter;
import org.apache.storm.drpc.DRPCSpout;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;
import org.apache.storm.drpc.ReturnResults;
import org.apache.storm.topology.TopologyBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/8/3 16:05
 * Desc：本地模式
 */
public class MainLocal {
    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        LocalDRPC drpc = new LocalDRPC();

        DRPCSpout spout = new DRPCSpout("exclamation", drpc);
        builder.setSpout("drpc", spout);
        builder.setBolt("exclaim", new ExclaimBolt(), 3).shuffleGrouping("drpc");
        builder.setBolt("return", new ReturnResults(), 3).shuffleGrouping("exclaim");

        LocalCluster cluster = new LocalCluster();
        Config conf = new Config();
        cluster.submitTopology("exclaim", conf, builder.createTopology());

        System.out.println(drpc.execute("exclamation", "aaa"));
        System.out.println(drpc.execute("exclamation", "bbb"));

    }
}
