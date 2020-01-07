package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 11:42
 */
public enum CouponTypeEnum {
    NULL(-1, "", "未知"),
    DISCOUNT(0, "DISCOUNT", "打折券"),
    THRESHOLD(1, "SUCC", "满减券"),
    ;
    private static final Map<String, CouponTypeEnum> codeMap = new HashMap<>();
    private static final Map<Integer, String> indexDescMap = new HashMap<>();

    static {
        for (CouponTypeEnum items : CouponTypeEnum.values()) {
            codeMap.put(items.getCode(), items);
            indexDescMap.put(items.getIndex(), items.getDesc());
        }
    }

    CouponTypeEnum(int index, String code, String desc) {
        this.index = index;
        this.code = code;
        this.desc = desc;
    }

    private int index;
    private String code;
    private String desc;

    public int getIndex() {
        return index;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static Map<Integer, String> getIndexDescMap() {
        return indexDescMap;
    }

    public static String getDescByCode(String code) {
        CouponTypeEnum acceptOrderStatusEnum = codeMap.get(code);
        return acceptOrderStatusEnum == null ? NULL.getDesc() : acceptOrderStatusEnum.getDesc();

    }

    public static Map<String, CouponTypeEnum> getCodeMap() {
        return codeMap;
    }
}
