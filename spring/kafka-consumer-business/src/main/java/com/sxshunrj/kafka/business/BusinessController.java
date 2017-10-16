package com.sxshunrj.kafka.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/16 17:46
 * Desc：
 */
@Controller
@RequestMapping("business")
public class BusinessController {

    @RequestMapping("receive1")
    @ResponseBody
    public String receive1(String msg){
        System.out.println("receive1--->"+msg);
        return "success1";
    }

    @RequestMapping("receive2")
    @ResponseBody
    public String receive2(String msg){
        System.out.println("receive2--->"+msg);
        return "success2";
    }

    @RequestMapping("receive3")
    @ResponseBody
    public String receive3(String msg){
        System.out.println("receive3--->"+msg);
        return "success3";
    }

}
