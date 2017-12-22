package com.test;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/9/7 10:05
 * Desc：
 */
public class B extends A{
    public B(){
        System.out.println("B");
    }

    @Override
    void t() {
        System.out.println("B.t");
    }
}
