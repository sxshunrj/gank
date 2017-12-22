package com.sxshunrj.kafka.test

import com.alibaba.fastjson.JSON
import com.google.common.collect.HashBasedTable
import com.google.common.collect.Lists
import com.google.common.collect.Table
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.BeansException
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.util.CollectionUtils

import java.lang.reflect.Field
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/12 19:37
 * Desc：
 */
@Component
class ListenerUtil implements ApplicationContextAware {
    protected static final Logger logger = LoggerFactory.getLogger(ListenerUtil.class);

    @Autowired ApplicationContext applicationContext;

    /**
     * key：topicName + groupId
     * val：callbackurl list
     */
    private static Table<String, String, List<String>> table = HashBasedTable.create();

    public void addCallBack(String topicName, String groupId, String callBackUrl){
        List<String> urls = table.get(topicName, groupId);
        if(CollectionUtils.isEmpty(urls)){
            urls = Lists.newArrayList(callBackUrl);
        }else if(!urls.contains(callBackUrl)){
            urls.add(callBackUrl);
        }
        table.put(topicName, groupId, urls);
        logger.info("当前列表为："+ JSON.toJSONString(table.columnMap()));
    }


    public void addListenerTopic(String topicName){
        Map memberValues = getListenerAnnotationValues();
        logger.info("添加前："+JSON.toJSONString(memberValues));
        String[] topics = (String[]) memberValues.get("topics");

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < topics.length; i++) {
            list.add(topics[i]);
        }
        list.add(topicName);

        topics = list.toArray(new String[0]);
        memberValues.put("topics", topics);
        logger.info("添加后："+JSON.toJSONString(getListenerAnnotationValues()));

        BeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory()
        System.out.println("--"+applicationContext.getBean(Listener.class).getClass().getName())
        DefaultListableBeanFactory defaultListableBeanFactory =(DefaultListableBeanFactory) beanFactory;
        BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition("com.sxshunrj.kafka.test.Listener");
        beanDefinition.setBeanClassName("com.sxshunrj.kafka.test.Listener");
        defaultListableBeanFactory.registerBeanDefinition("com.sxshunrj.kafka.test.Listener", beanDefinition);

    }

    public Map<String, Object> getListenerAnnotationValues(){
        try {
            Method listen = Listener.class.getMethod("listen", ConsumerRecord.class);
            KafkaListener kafkaListenerAnno = AnnotationUtils.findAnnotation(listen, KafkaListener.class);

            InvocationHandler invocationHandler = Proxy.getInvocationHandler(kafkaListenerAnno);
            Field hField = invocationHandler.getClass().getDeclaredField("memberValues");
            hField.setAccessible(true);
            Map memberValues = (Map) hField.get(invocationHandler);

            return memberValues;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
