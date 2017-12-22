package com.sxshunrj.springboot.common.service;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/15 11:17
 * Desc：
 */
public class TestService {

    private String p1;
    private String p2;
    private String p3;

    public void test(){
        System.out.print("p1:"+p1);
        System.out.print("，p2:"+p2);
        System.out.println("，p3:"+p3);
        System.out.println("TestService.test()");
    }

    public void init(){
        System.out.println("TestService.init()");
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }
}
