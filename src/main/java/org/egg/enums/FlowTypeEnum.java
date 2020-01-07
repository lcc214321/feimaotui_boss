package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author cdt
 * @Description 流水类型
 * @date: 2018/3/16 18:08
 */
public enum FlowTypeEnum {
    ADD(0, "增加"),
    SUB(1, "扣减"),
    ;
    private int index;
    private String desc;
    private static final Map<Integer, String> indexDescMap = new HashedMap();
    static {
        for (FlowTypeEnum item : FlowTypeEnum.values()) {
            indexDescMap.put(item.getIndex(), item.getDesc());
        }
    }
    FlowTypeEnum(int index, String desc) {
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
