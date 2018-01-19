package grails3demo

import grails.events.Events
import org.grails.events.ClosureEventConsumer
import org.springframework.stereotype.Component
import reactor.bus.Bus

import javax.annotation.PostConstruct

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/18 10:31
 * Desc：
 */
@Component
class MyProvider implements Events {
    @PostConstruct
    void init() {
        println "====MyProvider init........."
//        notify "myEvent", "myData"
        sendAndReceive "myEvent", "myData", {
            println "Got response!"
        }
    }
}
