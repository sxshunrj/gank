package com.sxshunrj.kafka.test

import kafka.admin.AdminUtils
import kafka.admin.RackAwareMode
import kafka.admin.TopicCommand
import kafka.server.ConfigType
import kafka.utils.ZkUtils
import org.apache.kafka.common.errors.TopicExistsException
import org.apache.kafka.common.security.JaasUtils
import org.springframework.stereotype.Component

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/10 17:07
 * Desc： http://www.cnblogs.com/huxi2b/p/6592862.html
 */
@Component
class TopicService {
    private static ZkUtils zkUtils = null
    static {
        zkUtils = ZkUtils.apply("192.168.10.14:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
    }

    def getTopic(topicName){
        Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topicName);

        Iterator it = props.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        props
    }

    def deleteTopic(topicName){
        def delRet = AdminUtils.deleteTopic(zkUtils, topicName);

        delRet
    }


    def createTopic(topicName){
        boolean exists = false;
        try {
            def createRet = AdminUtils.createTopic(zkUtils, topicName, 1, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);
        }catch (TopicExistsException e){
            exists = true
            e
        }
        exists
    }

    def describe(topicName){
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(1024*3);
        PrintStream cacheStream = new PrintStream(byteStream);
        PrintStream oldStream = System.out;

        System.setOut(cacheStream);

        String[] options = ["--describe",
                        "--zookeeper",
                        "192.168.10.14:2181",
                        "--topic",
                       topicName]
        TopicCommand.main(options);

        String message = byteStream.toString();
        System.setOut(oldStream);
        message
    }
}
