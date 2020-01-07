package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 收费计算类型
 * 目前只有满减和满折
 * Created by chendatao on 2018/7/22.
 */
public enum FeeTypeEnum {
    /**
     * 满减
     */
    THRESHOLD_SUBTRACT(0,"满减"),
    /**
     * 满折
     */
    THRESHOLD_DISCOUNT(1,"满折");
    private int code;
    private String desc;
    private static Map<Integer, FeeTypeEnum> codeMap = new HashMap<>();
    private static Map<Integer, String> codeDescMap = new HashMap<>();
    static {
        for (FeeTypeEnum feeRuleTypeEnum : FeeTypeEnum.values()) {
            codeMap.put(feeRuleTypeEnum.getCode(), feeRuleTypeEnum);
            codeDescMap.put(feeRuleTypeEnum.getCode(), feeRuleTypeEnum.getDesc());
        }
    }
    FeeTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static FeeTypeEnum getEnumByCode(Integer code) {
        return codeMap.get(code);
    }
    public static Map<Integer, String> getCodeDescMap() {
        return codeDescMap;
    }
}
