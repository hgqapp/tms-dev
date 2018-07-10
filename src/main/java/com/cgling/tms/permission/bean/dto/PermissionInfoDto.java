package com.cgling.tms.permission.bean.dto;

public class PermissionInfoDto {
    
    /**
     * 权限ID，自增主键
     */
    private Long permissionId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码，编码规则  系统模块:功能点:具体动作
     */
    private String code;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间，初始值等于创建时间
     */
    private Long updateTime;

    /**
     * 权限ID，自增主键
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 权限ID，自增主键
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 编码，编码规则  系统模块:功能点:具体动作
     */
    public String getCode() {
        return code;
    }

    /**
     * 编码，编码规则  系统模块:功能点:具体动作
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间，初始值等于创建时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间，初始值等于创建时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

}