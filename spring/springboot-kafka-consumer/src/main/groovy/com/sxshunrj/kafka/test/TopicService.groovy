package com.sxshunrj.kafka.test

import com.alibaba.fastjson.JSON
import kafka.admin.AdminUtils
import kafka.admin.RackAwareMode
import kafka.admin.TopicCommand
import kafka.server.ConfigType
import kafka.utils.ZkUtils
import org.apache.kafka.common.errors.TopicExistsException
import org.apache.kafka.common.security.JaasUtils
import org.springframework.stereotype.Component
import scala.collection.JavaConversions

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

    Set<String> getAllTopicName(){
        def allTopicConfigs = AdminUtils.fetchAllTopicConfigs(zkUtils)
        def names = allTopicConfigs.keySet()

        Set<String> ret = JavaConversions.asJavaSet(names)

        ret
    }

}
