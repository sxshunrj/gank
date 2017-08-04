package com.sxshunrj.test.drpc;

import org.apache.storm.Config;
import org.apache.storm.generated.DRPCExecutionException;
import org.apache.storm.thrift.TException;
import org.apache.storm.utils.DRPCClient;

public class DrpcClient {
 public static void main(String[] args) throws TException, DRPCExecutionException {

     Config conf = new Config();
     conf.setDebug(false);
     conf.put("storm.thrift.transport", "org.apache.storm.security.auth.SimpleTransportPlugin");
     conf.put(Config.STORM_NIMBUS_RETRY_TIMES, 3);
     conf.put(Config.STORM_NIMBUS_RETRY_INTERVAL, 10);
     conf.put(Config.STORM_NIMBUS_RETRY_INTERVAL_CEILING, 20);
     conf.put(Config.DRPC_MAX_BUFFER_SIZE, 1048576);
     DRPCClient drpcClient = new DRPCClient(conf, "192.168.10.14", 6704);

     long start = System.currentTimeMillis();
     String result = drpcClient.execute("hellodrpcserver","msg000001");
     long end = System.currentTimeMillis();
     System.out.println(result);
 }
}