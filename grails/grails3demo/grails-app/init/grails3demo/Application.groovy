package grails3demo

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import reactor.bus.EventBus

@SpringBootApplication(scanBasePackages = ['grails3demo'])
class Application extends GrailsAutoConfiguration {

    @Bean
    public ExamplePlugin getEventBus(){
        new ExamplePlugin()
    }

    @Override
    void onStartup(Map<String, Object> event) {
        super.onStartup(event)
        println("======Application  onStartup....")
    }

    @Override
    void onShutdown(Map<String, Object> event) {
        super.onShutdown(event)
        println("======Application  onShutdown....")
    }

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}