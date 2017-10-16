package com.sxshunrj.kafka.consumer.controller

import com.google.common.base.Preconditions
import com.sxshunrj.kafka.consumer.service.BusinessClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/16 14:44
 * Desc：供业务方调用的api
 */
@RestController
@RequestMapping(value="kafkaConsumer", method = RequestMethod.POST)
class KafkaConsumerController {

    @Autowired
    BusinessClientService businessClientService

    @RequestMapping(value="registerClient")
    def registerClient(String topicName, String groupId, String callbackUrl){
        Preconditions.checkNotNull(topicName)
        Preconditions.checkNotNull(groupId)
        Preconditions.checkNotNull(callbackUrl)

        businessClientService.addClient(topicName, groupId, callbackUrl)

        "success"
    }

    @RequestMapping(value="unregisterClient")
    def unregisterClient(String topicName, String groupId){
        Preconditions.checkNotNull(topicName)
        Preconditions.checkNotNull(groupId)

        businessClientService.removeClient(topicName, groupId)

        "success"
    }


}
