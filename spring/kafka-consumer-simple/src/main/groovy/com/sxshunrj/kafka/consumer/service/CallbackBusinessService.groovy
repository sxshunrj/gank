package com.sxshunrj.kafka.consumer.service

import com.alibaba.fastjson.JSON
import com.google.common.base.Preconditions
import com.google.common.collect.Maps
import com.sxshunrj.kafka.consumer.dto.MsgDto
import com.sxshunrj.kafka.consumer.util.HttpClientUtil
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/16 15:15
 * Desc：回调业务系统
 */
@Component
class CallbackBusinessService {

    def logger = LoggerFactory.getLogger(CallbackBusinessService)

    @Autowired
    BusinessClientService businessClientService

    def callback(MsgDto msgDto, String topicName, String groupId){
        callback(msgDto, businessClientService.getClientCallbackUrls(topicName, groupId))
    }

    /**
     *
     * @param msg
     * @param callbackUrl
     * @return 回调成功的client个数
     */
    def callback(MsgDto msgDto, List<String> callbackUrls){
        Preconditions.checkNotNull(msgDto)
        Preconditions.checkNotNull(callbackUrls)

        def paramMap = Maps.newHashMap()
        paramMap.put("msg", JSON.toJSONString(msgDto))

        int successCallbackSize = 0
        callbackUrls.each {
            def callbackUrl = it
            // TODO 需要添加重试策略
            def httpRet = HttpClientUtil.doPost(callbackUrl, paramMap)
            successCallbackSize ++
            logger.info("第"+successCallbackSize+"个client，回调地址为:["+callbackUrl+"]，回调内容为：["+JSON.toJSONString(msgDto)+"]，返回:["+httpRet+"]")
        }

        successCallbackSize
    }


}
