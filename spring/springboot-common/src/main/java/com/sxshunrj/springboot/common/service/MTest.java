package com.sxshunrj.springboot.common.service;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/25 11:54
 * Desc：
 */
public class MTest {
    public void t(){
        AtomicBoolean running  = new AtomicBoolean();
        System.out.println(running.get());
        System.out.println(running.get());
        System.out.println(running.get());
        System.out.println(running.get());
    }
    public static void main(String[] args) {
        new MTest().t();
    }
}
