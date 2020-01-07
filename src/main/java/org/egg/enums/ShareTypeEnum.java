package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

//0.朋友圈分享 1.发送给朋友 2.qq 3.微博 4.qq空间
public enum ShareTypeEnum {
    TIMELINE(0,"朋友圈分享"),
    FRIEND(1,"发送给朋友"),
    QQ(2,"QQ"),
    WEIBO(3,"微博"),
    QQ_ZONE(4,"qq空间"),
    ;

    private int code;
    private String desc;

    ShareTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static Map<Integer, ShareTypeEnum> codeMap = new HashMap<>();
    private static Map<Integer, String> codeDescMap = new HashMap<>();

    static {
        for (ShareTypeEnum items : ShareTypeEnum.values()) {
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
