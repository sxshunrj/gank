package com.test;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/9/7 10:07
 * Desc：
 */
public class C extends B{
    public C(){
        System.out.println("C");
    }

    @Override
    void t() {
        System.out.println("C.t");
    }
}
