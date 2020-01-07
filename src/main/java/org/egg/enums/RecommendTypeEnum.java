package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cdt
 * @Description
 * @date: 2018/9/21 15:22
 */
public enum RecommendTypeEnum {
    PERSON(0, "个人推荐"),
    AGENT(1, "代理"),
    ;
    private int code;
    private String desc;
    private static Map<Integer, RecommendTypeEnum> codeMap = new HashMap<>();
    private static Map<Integer, String> codeDescMap = new HashMap<>();

    static {
        for (RecommendTypeEnum items : RecommendTypeEnum.values()) {
            codeMap.put(items.getCode(), items);
            codeDescMap.put(items.getCode(), items.getDesc());
        }
    }

    RecommendTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static RecommendTypeEnum getEnumByCode(Integer code) {
        return codeMap.get(code);
    }

    public static Map<Integer, String> getCodeDescMap() {
        return codeDescMap;
    }
}
