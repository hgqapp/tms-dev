package com.cgling.tms.user.model;

public class UserDetailsModel {
    
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 出身日期
     */
    private Long birthday;

    /**
     * 注册时间
     */
    private Long registrationTime;

    /**
     * 注册IP
     */
    private String registrationIp;

    /**
     * 最后登陆时间
     */
    private Long lastLoginTime;

    /**
     * 最后登陆IP地址
     */
    private String lastLoginIp;

    /**
     * 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 出身日期
     */
    public Long getBirthday() {
        return birthday;
    }

    /**
     * 出身日期
     */
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    /**
     * 注册时间
     */
    public Long getRegistrationTime() {
        return registrationTime;
    }

    /**
     * 注册时间
     */
    public void setRegistrationTime(Long registrationTime) {
        this.registrationTime = registrationTime;
    }

    /**
     * 注册IP
     */
    public String getRegistrationIp() {
        return registrationIp;
    }

    /**
     * 注册IP
     */
    public void setRegistrationIp(String registrationIp) {
        this.registrationIp = registrationIp;
    }

    /**
     * 最后登陆时间
     */
    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登陆时间
     */
    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 最后登陆IP地址
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 最后登陆IP地址
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
}