package com.cgling.tms.user.model;

public class UserOauthModel {
    
    /**
     * 认证方式ID，自增主键
     */
    private Long oauthId;

    /**
     * 认证方式名称
     */
    private String name;

    /**
     * 认证方式ID，自增主键
     */
    public Long getOauthId() {
        return oauthId;
    }

    /**
     * 认证方式ID，自增主键
     */
    public void setOauthId(Long oauthId) {
        this.oauthId = oauthId;
    }

    /**
     * 认证方式名称
     */
    public String getName() {
        return name;
    }

    /**
     * 认证方式名称
     */
    public void setName(String name) {
        this.name = name;
    }
}