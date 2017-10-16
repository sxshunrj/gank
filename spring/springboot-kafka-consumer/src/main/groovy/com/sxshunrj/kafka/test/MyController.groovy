package com.sxshunrj.kafka.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/11 19:24
 * Desc：
 */
@RestController
@RequestMapping(value="test")
class MyController {

    @Autowired ListenerUtil listenerUtil;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    def register(topicName, groupId, callbackUrl){
        listenerUtil.addCallBack(topicName, groupId, callbackUrl)
        "success"
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.GET)
    def addTopic(String topicName){
        listenerUtil.addListenerTopic(topicName)
        "success"
    }

}
