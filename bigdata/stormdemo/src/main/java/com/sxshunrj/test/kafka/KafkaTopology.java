package com.sxshunrj.test.kafka;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.kafka.*;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.kafka.KafkaSpout;

import java.util.UUID;

public class KafkaTopology {
    private static String topicName = "storm";
    private static String zkRoot = "/brokers/topics/"+topicName;

    public static void main(String[] args) {

        BrokerHosts hosts = new ZkHosts("192.168.10.14:2181");

        SpoutConfig spoutConfig = new SpoutConfig(hosts,topicName, zkRoot, UUID.randomUUID().toString());
        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        KafkaSpout kafkaSpout = new KafkaSpout(spoutConfig);

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("kafkaSpout",kafkaSpout);
        builder.setBolt("merchantsSalesBolt", new OutFile(), 2).shuffleGrouping("kafkaSpout");

        Config conf = new Config();
        conf.setDebug(true);

        if(args != null && args.length > 0) {
            conf.setNumWorkers(1);
            try {
                StormSubmitter.submitTopologyWithProgressBar(args[0], conf, builder.createTopology());
            } catch (AlreadyAliveException e) {
                e.printStackTrace();
            } catch (InvalidTopologyException e) {
                e.printStackTrace();
            } catch (AuthorizationException e) {
                e.printStackTrace();
            }
        } else {
            conf.setMaxSpoutPending(3);
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("ordersAnalysis", conf, builder.createTopology());
        }

    }
}