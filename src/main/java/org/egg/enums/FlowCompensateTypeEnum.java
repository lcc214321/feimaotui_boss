package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author cdt
 * @Description 流水理赔类型
 * @date: 2018/3/16 18:09
 */
public enum FlowCompensateTypeEnum {
    NONE(0, "无"),
    CPS(1, "补偿"),
    BAC(2, "违约（违约扣除后反退）"),
    REF(3, "退返"),
    ;
    private int index;
    private String desc;
    private static final Map<Integer, String> indexDescMap = new HashedMap();
    static {
        for (FlowCompensateTypeEnum item : FlowCompensateTypeEnum.values()) {
            indexDescMap.put(item.getIndex(), item.getDesc());
        }
    }
    FlowCompensateTypeEnum(int index, String desc) {
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
