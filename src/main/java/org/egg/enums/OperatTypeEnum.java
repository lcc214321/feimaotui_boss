package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author cdt
 * @Description
 * @date: 2017/12/4 13:27
 */
public enum OperatTypeEnum {
    LOGIN(0, "LOGIN"),
    LOGOUT(1, "LOGOUT"),
    REGISTER(2, "REGISTER"),;
    private int code;
    private String desc;
    private static final Map<Integer, String> codeDescMap = new HashedMap();

    static {
        for (OperatTypeEnum operatTypeEnum : OperatTypeEnum.values()) {
            codeDescMap.put(operatTypeEnum.getCode(), operatTypeEnum.getDesc());

        }
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    OperatTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(Integer code) {
        return codeDescMap.get(code);
    }

    public static Map<Integer, String> getCodeDescMap() {
        return codeDescMap;
    }
}
