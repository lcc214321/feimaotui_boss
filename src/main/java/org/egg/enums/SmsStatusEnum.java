package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/4 22:02
 */
public enum SmsStatusEnum {
    PROCESS("PROCESS", "处理中"),
    SUCC("SUCC", "成功"),
    FAIL("FAIL", "失败"),
    NOT_EFFECT("NOT_EFFECT", "失效"),
    ;
    private String  index;
    private String desc;
    private static final Map<String, SmsStatusEnum> indexEnumMap = new HashMap<>();
    private static final Map<String, String> indexDescMap = new HashedMap();

    static {
        for (SmsStatusEnum item : SmsStatusEnum.values()) {
            indexEnumMap.put(item.getIndex(), item);
            indexDescMap.put(item.getIndex(), item.getDesc());
        }
    }

    SmsStatusEnum(String index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public String getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByIndex(Integer index) {
        return indexDescMap.get(index);
    }

    public static Map<String, String> getIndexDescMap() {
        return indexDescMap;
    }
}