package com.sxshunrj.test.drpc;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.drpc.DRPCSpout;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;
import org.apache.storm.drpc.ReturnResults;
import org.apache.storm.topology.TopologyBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/8/3 16:05
 * Desc：远程模式
 */
public class MainRemote {
    public static void main(String[] args) {
        LinearDRPCTopologyBuilder builder = new LinearDRPCTopologyBuilder("hellodrpcserver");

        builder.addBolt(new ExclaimBolt());

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("exclaim", new Config(), builder.createRemoteTopology());
    }
}
