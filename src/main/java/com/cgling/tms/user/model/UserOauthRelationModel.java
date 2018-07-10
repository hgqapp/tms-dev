package com.cgling.tms.user.model;

public class UserOauthRelationModel {
    
    /**
     * 关系ID，自增主键
     */
    private Long relationId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 认证方式ID
     */
    private Long oauthId;

    private String openId;

    /**
     * 绑定状态，0：解绑；1：绑定（默认）
     */
    private Byte status;

    private Long createTime;

    /**
     * 关系ID，自增主键
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * 关系ID，自增主键
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

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
     * 认证方式ID
     */
    public Long getOauthId() {
        return oauthId;
    }

    /**
     * 认证方式ID
     */
    public void setOauthId(Long oauthId) {
        this.oauthId = oauthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 绑定状态，0：解绑；1：绑定（默认）
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 绑定状态，0：解绑；1：绑定（默认）
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}