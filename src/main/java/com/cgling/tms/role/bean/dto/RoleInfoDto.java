package com.cgling.tms.role.bean.dto;

public class RoleInfoDto {
    
    /**
     * 角色ID，自增主键
     */
    private Long roleId;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间，初始值等于创建时间
     */
    private Long updateTime;

    /**
     * 角色ID，自增主键
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID，自增主键
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
     * 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     */
    public void setDescription(String description) {
        this.description = description;
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