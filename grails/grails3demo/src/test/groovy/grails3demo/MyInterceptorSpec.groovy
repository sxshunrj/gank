package grails3demo


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MyInterceptor)
class MyInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test my interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"my")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
