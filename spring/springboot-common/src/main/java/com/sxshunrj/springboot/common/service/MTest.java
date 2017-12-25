package com.sxshunrj.springboot.common.service;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/25 11:54
 * Desc：
 */
public class MTest {
    public void t(){
        String p = this.getClass().getName();
        System.out.println(p);

    }
    public static void main(String[] args) {
        new MTest().t();
    }
}
