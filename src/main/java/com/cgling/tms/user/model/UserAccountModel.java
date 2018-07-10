package com.cgling.tms.user.model;

public class UserAccountModel {
    
    /**
     * 账户ID，自增主键
     */
    private Long accountId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账户名
     */
    private String accountName;

    /**
     * 账户类型，1：用户名；2：手机号；3：邮箱
     */
    private Byte accountType;

    /**
     * 账户ID，自增主键
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 账户ID，自增主键
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
     * 账户名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 账户名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 账户类型，1：用户名；2：手机号；3：邮箱
     */
    public Byte getAccountType() {
        return accountType;
    }

    /**
     * 账户类型，1：用户名；2：手机号；3：邮箱
     */
    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }
}