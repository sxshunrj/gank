package com.sxshunrj.test;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/21 15:01
 * Desc：
 */
public class User{

    String userName;
    String passWord;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
