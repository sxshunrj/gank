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
 * Desc：
 */
public class Main {
    public static void main(String[] args) {

        LinearDRPCTopologyBuilder builder = new LinearDRPCTopologyBuilder("reach");

        LocalDRPC drpc = new LocalDRPC();
        LocalCluster cluster = new LocalCluster();


        Config conf = new Config();
        conf.setDebug(false);
        conf.setMaxTaskParallelism(3);

        cluster.submitTopology("drpc-demo", conf, builder.createLocalTopology(drpc));

        System.out.println("Results for 'hello':" + drpc.execute("exclamation", "hello"));

        cluster.shutdown();
        drpc.shutdown();
    }
}
