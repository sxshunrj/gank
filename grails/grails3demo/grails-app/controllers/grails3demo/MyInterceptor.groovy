package grails3demo


class MyInterceptor {
    MyInterceptor(){
        match(controller:"tbArea", action: "index")
        matchAll().excludes(controller: "tbArea",actionName: "login")
        matchAll().excludes(controller: "tbArea",actionName: "exit")
    }

    boolean before() {
        println("====MyInterceptor before......")
        def loginState = session.getAttribute("login")
        println("====MyInterceptor loginState......"+loginState)
        loginState == null ? false : loginState
    }

    boolean after() {
        println("====MyInterceptor after......")
        true
    }

    void afterView() {
        println("====MyInterceptor afterView......")
        // no-op
    }
}
