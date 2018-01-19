package grails3demo

import grails.events.Events
import org.springframework.stereotype.Component
import reactor.spring.context.annotation.Consumer
import reactor.spring.context.annotation.Selector

import javax.annotation.PostConstruct

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/18 10:25
 * Desc：
 */
@Consumer
@Component
class MyConsumer2 implements Events {
    @Selector('myEvent')
    void myEventListener(Object data) {
        println "GOT EVENT $data"
    }
}
