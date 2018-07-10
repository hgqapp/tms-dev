package com.cgling.tms.common.consts;

/**
 * 存放常量类
 * @author houguangqiang
 * @date 2017-12-03
 * @since 1.0
 */
public class Constants {

    /** 默认int值 */
    public static final int DEFAULT_INTEGER_VALUE = 0;
    /** 默认Longr值 */
    public static final long DEFAULT_LOING_VALUE = 0L;
    /** 默认String值 */
    public static final String DEFAULT_STRING_VALUE = "";
    /** 默认Boolean类型的true值 */
    public static final int DEFAULT_BOOLEAN_TRUE_VALUE = 1;
    /** 默认Boolean类型的false值 */
    public static final int DEFAULT_BOOLEAN_FALSE_VALUE = 0;

    /** 默认状态码 */
    public enum Status {

        /** 启用 */
        ENABLE((byte)1),
        /** 禁用 */
        DISABLE((byte)0),
        ;
        byte value;

        Status(byte value){
            this.value = value;
        }

        public byte getValue() {
            return value;
        }

        public static Status of(byte value) {
            switch (value) {
                case 1 : return ENABLE;
                case 2 : return DISABLE;
                default: return null;
            }

        }

    }
    /** 权限码类型 */
    public enum PermissionCodeType {

        /** 菜单 */
        MENU((byte)1),
        /** 操作 */
        OPERATION((byte)2),
        ;
        byte value;

        PermissionCodeType(byte value){
            this.value = value;
        }

        public byte getValue() {
            return value;
        }

        public static PermissionCodeType of(byte value) {
            switch (value) {
                case 1 : return MENU;
                case 2 : return OPERATION;
                default: return null;
            }

        }

    }

    /** 菜单类型 */
    public enum MenuType {

        /** 目录 */
        DIRECTORY((byte)1),
        /** 菜单 */
        MENU((byte)2),
        /** 按钮 */
        BUTTON((byte)3),
        ;
        byte value;

        MenuType(byte value){
            this.value = value;
        }

        public byte getValue() {
            return value;
        }

        public static MenuType of(byte value) {
            switch (value) {
                case 1 : return DIRECTORY;
                case 2 : return MENU;
                case 3 : return BUTTON;
                default: return null;
            }

        }

    }


    private Constants(){}
}
