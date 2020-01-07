package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/16 15:02
 */
public enum  BossUserLevelEnum {
    LEVEL_ONE("LEVEL_ONE","一级用户","LEVEL_ONE_URL"),
    LEVEL_TWO("LEVEL_TWO","二级用户","LEVEL_TWO_URL"),
    BOSS("BOSS","BOSS","LEVEL_TWO_URL"),
    ;

    private static Map<String, String> codeDescMap = new HashMap<>();
    private static Map<String, BossUserLevelEnum> codeEnumMap = new HashMap<>();
    static {
        for (BossUserLevelEnum bossUserLevelEnum : BossUserLevelEnum.values()) {
            codeDescMap.put(bossUserLevelEnum.getCode(), bossUserLevelEnum.getDesc());
            codeEnumMap.put(bossUserLevelEnum.getCode(), bossUserLevelEnum);
        }
    }
    private String code;
    private String desc;
    private String url;

    BossUserLevelEnum(String code, String desc, String url) {
        this.code = code;
        this.desc = desc;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public static Map<String, String> getCodeDescMap() {
        return codeDescMap;
    }

    public static Map<String, BossUserLevelEnum> getCodeEnumMap() {
        return codeEnumMap;
    }
}
