package grails3demo

import grails.plugins.Plugin
import groovy.transform.CompileStatic

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/17 17:30
 * Desc：
 */
class ExamplePlugin extends Plugin {

    @Override
    void doWithDynamicMethods() {
        super.doWithDynamicMethods()
        for (controllerClass in grailsApplication.controllerClasses) {
            controllerClass.metaClass.myNewMethod = {-> println "hello world" }
        }
    }
}
