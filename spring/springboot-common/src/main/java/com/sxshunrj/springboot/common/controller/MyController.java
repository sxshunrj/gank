package com.sxshunrj.springboot.common.controller;

import com.google.common.collect.Maps;
import com.sxshunrj.springboot.common.extend.RegisterBean;
import com.sxshunrj.springboot.common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/15 14:55
 * Desc：
 */
@RestController
@RequestMapping("my")
public class MyController {

    @Autowired
    RegisterBean registerBean;

    @Lazy
    @Autowired
    TestService testService;

    @GetMapping("t1")
    public void t1(){
        RegisterBean.BeanInfo beanInfo = new RegisterBean.BeanInfo();
        beanInfo.setClazz(TestService.class);
        beanInfo.setInitMethodName("init");
        Map<String, Object> propertyMap = Maps.newHashMap();
        propertyMap.put("p1", "111111");
        propertyMap.put("p2", "222222");
        propertyMap.put("p3", "333333");
        beanInfo.setPropertyMap(propertyMap);

        registerBean.postProcessBeanFactory(beanInfo);
    }

    @GetMapping("t2")
    public void  t2(){
//        RegisterBean.getAppContext().getBean(TestService.class).test()
        testService.test();
    }
}
