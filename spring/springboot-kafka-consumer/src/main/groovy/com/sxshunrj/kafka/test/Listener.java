package com.sxshunrj.kafka.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.*;

public class Listener implements InitializingBean {
    protected static final Logger logger = LoggerFactory.getLogger(Listener.class);

    @Autowired
    TopicService topicService;

    @Autowired
    ListenerUtil listenerUtil;

    @KafkaListener
//    @KafkaListener(topicPattern  = "^[A-Za-z][A-Za-z1-9_-]+$")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("topic:"+record.topic());
        System.out.println("value:"+record.value());
        System.out.println("key:"+record.key());
        System.out.println("offset:"+record.offset());
        System.out.println("partition:"+record.partition());
        System.out.println("checksum:"+record.checksum());
        System.out.println("timestampType:"+record.timestampType());
        System.out.println("timestamp:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(record.timestamp())));
        System.out.println("---------------------------------------------------------");
    }


    /**
     * 使当前监听器监听所有已有的topic
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Set<String> allTopicName = topicService.getAllTopicName();
        allTopicName = new HashSet<>(allTopicName);
        allTopicName.remove("__consumer_offsets");
        String[] topics = allTopicName.toArray(new String[]{});

        Map memberValues = listenerUtil.getListenerAnnotationValues();
        logger.info("修改前："+JSON.toJSONString(memberValues));
        memberValues.put("topics", topics);
        logger.info("修改后："+JSON.toJSONString(listenerUtil.getListenerAnnotationValues()));
        System.out.println("aa->"+listenerUtil.getApplicationContext().getApplicationName());
    }

}