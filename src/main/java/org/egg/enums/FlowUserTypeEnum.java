package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author cdt
 * @Description 流水用户类型
 * @date: 2018/3/16 18:08
 */
public enum FlowUserTypeEnum {
    NONE(0,"不区分"),
    PUB_USER(1,"发单"),
    ACCEPT_USER(2,"接单"),
    FEE_PLATFORM(3,"手续费平台"),
    ;
    private int index;
    private String desc;
    private static final Map<Integer, String> indexDescMap = new HashedMap();
    static {
        for (FlowUserTypeEnum item : FlowUserTypeEnum.values()) {
            indexDescMap.put(item.getIndex(), item.getDesc());
        }
    }
    FlowUserTypeEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }
    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }
    public static String getDescByIndex(Integer code) {
        return indexDescMap.get(code);
    }

    public static Map<Integer, String> getIndexDescMap() {
        return indexDescMap;
    }
}
