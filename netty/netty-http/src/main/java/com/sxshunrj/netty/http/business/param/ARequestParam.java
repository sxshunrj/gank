package com.sxshunrj.netty.http.business.param;

import com.sxshunrj.netty.http.common.param.request.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/16 14:48
 * Desc：
 */
public class ARequestParam extends RequestParam {
    private int age;
    private String name;
    private String address;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
