package com.sxshunrj.test;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/19 15:09
 * Desc：
 */
public class People {
    private String id;
    private String name;
    private Integer age;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
