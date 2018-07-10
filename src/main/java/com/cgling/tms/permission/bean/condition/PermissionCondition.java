package com.cgling.tms.permission.bean.condition;

public class PermissionCondition {

    /**
     * 名称
     */
    private String name;

    /**
     * 编码，编码规则  系统模块:功能点:具体动作
     */
    private String code;

    /**
     * 类型，1：菜单；
     */
    private Byte type;

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
     * 类型，1：菜单；
     */
    public Byte getType() {
        return type;
    }

    /**
     * 类型，1：菜单；
     */
    public void setType(Byte type) {
        this.type = type;
    }
}
