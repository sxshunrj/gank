package grails3demo

import grails.events.Events
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/18 10:25
 * Desc：
 */
//@Component
class MyConsumer implements Events {
    @PostConstruct
    void init() {
        println "====MyConsumer init........."
        on("myEvent") {
            println "myEvent fired!"
        }
    }
}
