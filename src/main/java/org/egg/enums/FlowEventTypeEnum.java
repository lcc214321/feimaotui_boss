package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cdt
 * @Description 资金流水操作事件
 * @date: 2018/3/16 19:05
 */
public enum FlowEventTypeEnum {
    PUBISH_PLEDGE(1, "PUB", "发布单押金"),
    FINISH_ACCOUNT(2, "FINISH", "结算"),
    REFUND(3, "REFUND", "退返"),
    RECHARGE(4, "RECHARGE", "充值"),;
    private int index;
    private String code;
    private String desc;
    private static Map<String, FlowEventTypeEnum> codeMap = new HashMap<>();
    private static Map<Integer, FlowEventTypeEnum> indexMap = new HashMap<>();

    static {
        for (FlowEventTypeEnum flowEventTypeenum : FlowEventTypeEnum.values()) {
            codeMap.put(flowEventTypeenum.getCode(), flowEventTypeenum);
            indexMap.put(flowEventTypeenum.getIndex(), flowEventTypeenum);
        }
    }

    FlowEventTypeEnum(int index, String code, String desc) {
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

    public static FlowEventTypeEnum getEnumByCode(String code) {
        return codeMap.get(code);
    }

    public static FlowEventTypeEnum getEnumByIndex(Integer index) {
        return indexMap.get(index);
    }
}
