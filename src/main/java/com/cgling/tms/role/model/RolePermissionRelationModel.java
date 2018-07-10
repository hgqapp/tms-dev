package com.cgling.tms.role.model;

public class RolePermissionRelationModel {
    
    /**
     * 关系ID，自增主键
     */
    private Long relationId;

    /**
     * 权限ID
     */
    private Long permissionId;

    /**
     * 角色ID
     */
    private Long roleId;

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
     * 权限ID
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 权限ID
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}