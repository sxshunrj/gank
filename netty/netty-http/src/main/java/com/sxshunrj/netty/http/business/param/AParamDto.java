package com.sxshunrj.netty.http.business.param;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/17 10:43
 * Desc：
 */
public class AParamDto {
    int age;
    String address;
    String name;

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}
