package com.cgling.tms.menu.bean.condition;

public class MenuCondition {

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
     * 状态，0：禁用；1：启用（默认）
     */
    private Byte status;

    /**
     * 菜单编码
     */
    private String code;

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