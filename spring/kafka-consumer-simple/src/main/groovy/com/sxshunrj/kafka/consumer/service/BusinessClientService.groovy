package com.sxshunrj.kafka.consumer.service

import com.alibaba.fastjson.JSON
import com.google.common.base.Preconditions
import com.google.common.collect.HashBasedTable
import com.google.common.collect.Lists
import com.google.common.collect.Table
import com.sxshunrj.kafka.consumer.receive.MessageReceive
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.util.CollectionUtils

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/16 15:05
 * Desc：
 */
@Component
class BusinessClientService implements InitializingBean {

    @Autowired
    CallbackBusinessService callbackBusinessService

    def logger = LoggerFactory.getLogger(BusinessClientService)

    /**
     * key：topicName + groupId
     * val：callbackurl list
     */
    private static Table<String, String, List<String>> table = HashBasedTable.create();

    public void addClient(String topicName, String groupId, String callBackUrl){
        List<String> urls = table.get(topicName, groupId);
        if(null == urls || urls.size() == 0){
            urls = Lists.newArrayList(callBackUrl);
        }else if(!urls.contains(callBackUrl)){
            urls.add(callBackUrl);
        }
        table.put(topicName, groupId, urls);//TODO 需要持久化
        logger.info("当前列表为："+ JSON.toJSONString(table.columnMap()));

        new MessageReceive(topicName, groupId).setCallbackBusinessService(callbackBusinessService).start()
    }

    /**
     * 移除业务客户端
     *
     * TODO 还需要某种策略定时移除客户端
     * @param topicName
     * @param groupId
     */
    public void removeClient(String topicName, String groupId){
        if(table.size() > 0){
            table.remove(topicName, groupId)
            logger.info("当前列表为："+ JSON.toJSONString(table.columnMap()));
        }
    }

    public List<String> getClientCallbackUrls(String topicName, String groupId){
        Preconditions.checkNotNull(topicName)
        Preconditions.checkNotNull(groupId)

//        List<String> callbackUrls = Lists.newArrayList();
//        Set<Table.Cell<String, String, List<String>>> cells = table.cellSet();
//
//        for(Table.Cell<String, String, List<String>> cell : cells){
//            if(topicName.equals(cell.getRowKey())){
//                callbackUrls.addAll(cell.getValue());
//            }
//        }
//        callbackUrls

        table.get(topicName, groupId)
    }

    @Override
    void afterPropertiesSet() throws Exception {
        //TODO 启动时加载需要监听的列表

    }
}
