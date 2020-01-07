package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cdt
 * @Description 结算事件类型
 * @date: 2018/3/16 19:19
 */
public enum FinishAccountTypeEnum {
    NORMAL(0, "NORMAL", "正常结算"),
    ;
    private int index;
    private String code;
    private String desc;
    private static final Map<Integer, FinishAccountTypeEnum> indexMap = new HashMap<>();
    private static final Map<Integer, String> indexDescMap = new HashMap<>();

    static {
        for (FinishAccountTypeEnum finishAccountTypeEnum : FinishAccountTypeEnum.values()) {
            indexMap.put(finishAccountTypeEnum.getIndex(), finishAccountTypeEnum);
            indexDescMap.put(finishAccountTypeEnum.getIndex(), finishAccountTypeEnum.getDesc());
        }
    }

    FinishAccountTypeEnum(int index, String code, String desc) {
        this.index = index;
        this.code = code;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public static Map<Integer, String> getIndexDescMap() {
        return indexDescMap;
    }

    public static FinishAccountTypeEnum getEnumByIndex(Integer index) {
        return indexMap.get(index);
    }
}
