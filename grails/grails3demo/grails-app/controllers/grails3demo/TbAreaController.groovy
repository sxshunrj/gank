package grails3demo

import grails.rest.RestfulController
import groovy.transform.CompileStatic
import org.grails.web.json.JSONObject

class TbAreaController extends RestfulController<TbArea> {
    static responseFormats = ['json', "html"]

    TbAreaController(Class resource) {
        super(resource)
    }

    def index() {
//        def areas = TbArea.list()
        def areas = super.listAllResources()
        respond areas
    }

    def index2() {
//        def areas = TbArea.list()
        def areas = super.listAllResources()
        respond areas
    }

    def login(){
        session.setAttribute("login", true)

        JSONObject json = new JSONObject();
        json.put("loginState",true)
        respond json
    }

    def exit(){
        session.setAttribute("login", false)

        JSONObject json = new JSONObject();
        json.put("loginState",true)
        respond json
    }
}
