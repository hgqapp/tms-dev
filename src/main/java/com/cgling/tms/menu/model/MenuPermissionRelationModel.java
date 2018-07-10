package com.cgling.tms.menu.model;

public class MenuPermissionRelationModel {
    
    /**
     * 关系ID，自增主键
     */
    private Long relationId;

    /**
     * 权限ID
     */
    private Long permissionId;

    /**
     * 菜单ID
     */
    private Long menuId;

    public MenuPermissionRelationModel() {
    }

    public MenuPermissionRelationModel(Long menuId, Long permissionId) {
        this.menuId = menuId;
        this.permissionId = permissionId;
    }

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
     * 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}