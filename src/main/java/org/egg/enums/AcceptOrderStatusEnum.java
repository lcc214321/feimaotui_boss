package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chendatao on 2017/12/8.
 */
public enum AcceptOrderStatusEnum {
    //    已接单  接到货物 已完成 已取消
    NULL(-1, "", "未知"),
    ACCEPT_SUCC(0, "ACCEPT_SUCC", "已接单"),
    ACCEPT_ARR(1, "PENDING_CHECK", "接到货物"),
    SUCC(2, "SUCC", "成功结束"),
//    CANCEL(3, "CANCEL", "已取消"),
    ADMIN_CLOSE(4, "ADMIN_CLOSE", "关闭"),
    SUCC_ING(5, "SUCC_ING", "已确认成功系统转账中"),;
    private static final Map<String, AcceptOrderStatusEnum> codeMap = new HashMap<>();
    private static final Map<Integer, String> indexDescMap = new HashMap<>();

    static {
        for (AcceptOrderStatusEnum items : AcceptOrderStatusEnum.values()) {
            codeMap.put(items.getCode(), items);
            indexDescMap.put(items.getIndex(), items.getDesc());
        }
    }

    AcceptOrderStatusEnum(int index, String code, String desc) {
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
        AcceptOrderStatusEnum acceptOrderStatusEnum = codeMap.get(code);
        return acceptOrderStatusEnum == null ? NULL.getDesc() : acceptOrderStatusEnum.getDesc();

    }

    public static Map<String, AcceptOrderStatusEnum> getCodeMap() {
        return codeMap;
    }
}
