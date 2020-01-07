package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chendatao
 * @date 2017/12/8
 */
public enum CouponUserStatusEnum {
    NULL(-1, "", "未知"),
    NOT_USED(0, "NOT_USED", "未使用"),
    USED(1, "USED", "已使用"),
    EXPIRE(2, "EXPIRE", "过期"),
    ;
    private static final Map<String, CouponUserStatusEnum> codeMap = new HashMap<>();
    private static final Map<Integer, String> indexDescMap = new HashMap<>();

    static {
        for (CouponUserStatusEnum items : CouponUserStatusEnum.values()) {
            codeMap.put(items.getCode(), items);
            indexDescMap.put(items.getIndex(), items.getDesc());
        }
    }

    CouponUserStatusEnum(int index, String code, String desc) {
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
        CouponUserStatusEnum acceptOrderStatusEnum = codeMap.get(code);
        return acceptOrderStatusEnum == null ? NULL.getDesc() : acceptOrderStatusEnum.getDesc();

    }

    public static Map<String, CouponUserStatusEnum> getCodeMap() {
        return codeMap;
    }
}
