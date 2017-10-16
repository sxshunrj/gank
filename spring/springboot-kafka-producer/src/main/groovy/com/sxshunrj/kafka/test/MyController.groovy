package com.sxshunrj.kafka.test

import com.alibaba.fastjson.JSON;
import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.util.concurrent.FailureCallback
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.SuccessCallback;
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
            String message = request.getParameter("message");
            String topicName = request.getParameter("topicName")

            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, "key", message);
//            future.addCallback(new SuccessCallback<SendResult>() {
//                @Override
//                void onSuccess(SendResult result) {
//                    log.info("发送成功，返回结果为："+JSON.toJSONString(result))
//                }
//            },new FailureCallback() {
//                @Override
//                void onFailure(Throwable ex) {
//                    log.info("发送失败，异常为："+JSON.toJSONString(ex))
//                }
//            });

            SendResult sendResult = future.get()
            log.info("发送成功，返回结果为："+JSON.toJSONString(sendResult))
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
