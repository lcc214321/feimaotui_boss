package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chendatao on 2018/7/25.
 */
public enum  AccountFlowStatusEnum {
    //INIT(0,"初始化"),
    PROCESS(1,"处理中"),
    SUCC(2,"成功"),
    FAIL(3,"失败"),
    CLOSE(4,"关闭"),
            ;
    private int index;
    private String desc;
    private static final Map<Integer, AccountFlowStatusEnum> indexEnumMap = new HashMap<>();
    private static final Map<Integer, String> indexDescMap = new HashedMap();

    static {
        for (AccountFlowStatusEnum item : AccountFlowStatusEnum.values()) {
            indexEnumMap.put(item.getIndex(), item);
            indexDescMap.put(item.getIndex(), item.getDesc());
        }
    }
    AccountFlowStatusEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }
    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByIndex(Integer index) {
        return indexDescMap.get(index);
    }

    public static Map<Integer, String> getIndexDescMap() {
        return indexDescMap;
    }

    public static Map<Integer, AccountFlowStatusEnum> getIndexEnumMap() {
        return indexEnumMap;
    }
}
