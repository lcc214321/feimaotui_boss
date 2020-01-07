package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author cdt
 * @Description 账号类型
 * @date: 2018/3/16 18:49
 */
public enum FlowAccTypeEnum {
    PERSON(0,"个人"),
    PLATFORM(1,"平台"),
    ;
    private int index;
    private String desc;
    private static final Map<Integer, String> indexDescMap = new HashedMap();

    static {
        for (FlowAccTypeEnum item : FlowAccTypeEnum.values()) {
            indexDescMap.put(item.getIndex(), item.getDesc());
        }
    }
    FlowAccTypeEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }
    public static Map<Integer, String> getIndexDescMap() {
        return indexDescMap;
    }

    public static String getDescByIndex(Integer index) {
        return indexDescMap.get(index);
    }
}
