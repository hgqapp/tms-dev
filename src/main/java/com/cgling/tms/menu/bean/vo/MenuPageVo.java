package com.cgling.tms.menu.bean.vo;

public class MenuPageVo {

    /**
     * 菜单ID，主键自增
     */
    private Long menuId;

    /**
     * 名称
     */
    private String name;

    /**
     * 所属上级ID
     */
    private Long parentId;

    /**
     * 类型，1：目录；2：菜单；3：按钮
     */
    private Byte type;

    /**
     * 路径
     */
    private String uri;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态，0：禁用；1：启用（默认）
     */
    private Byte status;

    /**
     * 排序，默认0
     */
    private Integer orders;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间，初始值等于创建时间
     */
    private Long updateTime;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单ID，主键自增
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 菜单ID，主键自增
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
     * 所属上级ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 所属上级ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 类型，1：目录；2：菜单；3：按钮
     */
    public Byte getType() {
        return type;
    }

    /**
     * 类型，1：目录；2：菜单；3：按钮
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 路径
     */
    public String getUri() {
        return uri;
    }

    /**
     * 路径
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 状态，0：禁用；1：启用（默认）
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态，0：禁用；1：启用（默认）
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 排序，默认0
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * 排序，默认0
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
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

    /**
     * 菜单编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 菜单编码
     */
    public void setCode(String code) {
        this.code = code;
    }
}