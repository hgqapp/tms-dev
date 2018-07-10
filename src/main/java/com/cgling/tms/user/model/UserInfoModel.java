package com.cgling.tms.user.model;

public class UserInfoModel {
    
    /**
     * 用户ID，自增主键
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别，0：未知；1：男；2：女
     */
    private Byte sex;

    /**
     * 是否内部用户，0：不是（默认），1：是
     */
    private Byte internal;

    /**
     * 状态，1：正常（默认）；2：禁用；3：锁住；4：删除
     */
    private Byte status;

    /**
     * 注册时间
     */
    private Long createTime;

    /**
     * 更新时间，初始等于创建时间
     */
    private Long updateTime;

    /**
     * 用户ID，自增主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户ID，自增主键
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 性别，0：未知；1：男；2：女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 性别，0：未知；1：男；2：女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 是否内部用户，0：不是（默认），1：是
     */
    public Byte getInternal() {
        return internal;
    }

    /**
     * 是否内部用户，0：不是（默认），1：是
     */
    public void setInternal(Byte internal) {
        this.internal = internal;
    }

    /**
     * 状态，1：正常（默认）；2：禁用；3：锁住；4：删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态，1：正常（默认）；2：禁用；3：锁住；4：删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 注册时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 注册时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间，初始等于创建时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间，初始等于创建时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}