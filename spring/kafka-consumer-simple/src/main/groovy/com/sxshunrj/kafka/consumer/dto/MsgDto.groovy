package com.sxshunrj.kafka.consumer.dto

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/16 15:23
 * Desc：
 */
class MsgDto {

    String id
    String topic
    String content

    MsgDto(String id, String topic, String content) {
        this.id = id
        this.topic = topic
        this.content = content
    }
}
