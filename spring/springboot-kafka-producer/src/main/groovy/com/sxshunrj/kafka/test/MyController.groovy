package com.sxshunrj.kafka.test

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.util.StringUtils
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/5/25 17:33
 * Desc：
 */
@RestController
@RequestMapping(value="test")
public class MyController {

    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendKafka(HttpServletRequest request) {
        try {
            String topicName = request.getParameter("topicName")
            String key = request.getParameter("key")
            String message = request.getParameter("message");

            if(StringUtils.isEmpty(key)){
                key = null
            }

            /**
             <1> 若指定Partition ID,则PR被发送至指定Partition
             <2> 若未指定Partition ID,但指定了Key, PR会按照hasy(key)发送至对应Partition
             <3> 若既未指定Partition ID也没指定Key，PR会按照round-robin模式发送到每个Partition
             <4> 若同时指定了Partition ID和Key, PR只会发送到指定的Partition (Key不起作用，代码逻辑决定)
             */
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, key, message);

            SendResult sendResult = future.get()
            log.info("发送成功，返回结果为：")
            log.info("--producerRecord:"+JSON.toJSONString(sendResult.producerRecord))
            log.info("--recordMetadata:"+JSON.toJSONString(sendResult.recordMetadata))
            log.info("----------------------")

            if(null != sendResult){
                return sendResult
            }
        } catch (Exception e) {
            log.error("发送kafka失败", e);
            e.printStackTrace();
        }
        return "error"
    }
    @RequestMapping(value = "/getTopic", method = RequestMethod.GET)
    public String getTopic(String topicName){

//        return topicService.getTopic(topicName)
//        return topicService.deleteTopic(topicName)
//        return topicService.createTopic(topicName)
//        return topicService.describe(topicName)
        return topicService.getAllTopicName()
    }

}
