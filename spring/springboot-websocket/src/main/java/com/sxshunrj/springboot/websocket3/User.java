package com.sxshunrj.springboot.websocket3;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/25 16:48
 * Desc：
 */
public class User {
    private Integer id;
    private boolean isOnline;


    public User() {
    }

    public User(Integer id, boolean isOnline) {
        this.id = id;
        this.isOnline = isOnline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
