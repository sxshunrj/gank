package com.sxshunrj.springboot.common.controller;

import com.google.common.collect.Maps;
import com.sxshunrj.springboot.common.dto.rsp.Error;
import com.sxshunrj.springboot.common.extend.AppContext;
import com.sxshunrj.springboot.common.extend.RegisterBean;
import com.sxshunrj.springboot.common.extend.exception.MyPreconditions;
import com.sxshunrj.springboot.common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("registerBean")
public class RegisterBeanController {

    @Autowired
    RegisterBean registerBean;

    @GetMapping("t1")
    public void t1(){
        int i=1/0;
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
        MyPreconditions.checkState(false, Error.param_err);

        TestService testService = (TestService) AppContext.getAppContext().getBean(RegisterBean.toLowerCaseFirstOne(TestService.class));
        testService.test();
    }

    @GetMapping("t3")
    public void  t3(){
        MyPreconditions.checkState(false, "asdasdsd");
    }
}
