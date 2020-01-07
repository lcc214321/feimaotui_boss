package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShareStatusEnum {
    CONFIRM(0, "已分享"),
    CANCEL(1, "取消分享"),;

    private int code;
    private String desc;

    ShareStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static Map<Integer, ShareStatusEnum> codeMap = new HashMap<>();
    private static Map<Integer, String> codeDescMap = new HashMap<>();

    static {
        for (ShareStatusEnum items : ShareStatusEnum.values()) {
            codeMap.put(items.getCode(), items);
            codeDescMap.put(items.getCode(), items.getDesc());
        }
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByCode(Integer code) {
        return codeDescMap.get(code);
    }

    public static Map<Integer, String> getCodeDescMap() {
        return codeDescMap;
    }

}
