package com.sxshunrj.test.model;

import java.util.Date;

public class TbUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.id
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.username
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.real_name
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.password
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.status
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.role_id
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.create_date
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.update_date
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.change_pwd_time
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private Date changePwdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.last_login_time
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private Date lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.last_used_device
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    private String lastUsedDevice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.id
     *
     * @return the value of tb_user.id
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.id
     *
     * @param id the value for tb_user.id
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.username
     *
     * @return the value of tb_user.username
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.username
     *
     * @param username the value for tb_user.username
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.real_name
     *
     * @return the value of tb_user.real_name
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.real_name
     *
     * @param realName the value for tb_user.real_name
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.password
     *
     * @return the value of tb_user.password
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.password
     *
     * @param password the value for tb_user.password
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.status
     *
     * @return the value of tb_user.status
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.status
     *
     * @param status the value for tb_user.status
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.role_id
     *
     * @return the value of tb_user.role_id
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.role_id
     *
     * @param roleId the value for tb_user.role_id
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.create_date
     *
     * @return the value of tb_user.create_date
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.create_date
     *
     * @param createDate the value for tb_user.create_date
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.update_date
     *
     * @return the value of tb_user.update_date
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.update_date
     *
     * @param updateDate the value for tb_user.update_date
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.change_pwd_time
     *
     * @return the value of tb_user.change_pwd_time
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public Date getChangePwdTime() {
        return changePwdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.change_pwd_time
     *
     * @param changePwdTime the value for tb_user.change_pwd_time
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setChangePwdTime(Date changePwdTime) {
        this.changePwdTime = changePwdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.last_login_time
     *
     * @return the value of tb_user.last_login_time
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.last_login_time
     *
     * @param lastLoginTime the value for tb_user.last_login_time
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.last_used_device
     *
     * @return the value of tb_user.last_used_device
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public String getLastUsedDevice() {
        return lastUsedDevice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.last_used_device
     *
     * @param lastUsedDevice the value for tb_user.last_used_device
     *
     * @mbg.generated Fri Sep 01 18:19:38 CST 2017
     */
    public void setLastUsedDevice(String lastUsedDevice) {
        this.lastUsedDevice = lastUsedDevice == null ? null : lastUsedDevice.trim();
    }
}