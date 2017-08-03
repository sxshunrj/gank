package com.sxshunrj.test.test2;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class UpperBolt extends BaseBasicBolt {

       //业务处理逻辑
       @Override
       public void execute(Tuple tuple, BasicOutputCollector collector) {
              //先获取到上一个组件传递过来的数据,数据在tuple里面
              String godName = tuple.getString(0);

              //将商品名转换成大写
              String godName_upper = godName.toUpperCase();

              System.out.println("========原始："+godName+"======结果："+godName_upper);
              //将转换完成的商品名发送出去
              collector.emit(new Values(godName_upper));
       }

       //声明该bolt组件要发出去的tuple的字段
       @Override
       public void declareOutputFields(OutputFieldsDeclarer declarer) {
              declarer.declare(new Fields("uppername"));
       }
}

 