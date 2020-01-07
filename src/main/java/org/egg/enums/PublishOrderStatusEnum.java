package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by chendatao on 2017/12/8.
 */
public enum PublishOrderStatusEnum {
    //    未支付 支付并发布 已取消 被接单 接到货物 已完成
    NULL(-1, "null", "未知"),
    PENDING(0, "PENDING", "待支付"),
    PAY_SUCC(1, "PAY_SUCC", "待接单"),
    ACCEPT_PENDING(2, "ACCEPT_PENDING", "接单中"),
    ACCEPT_ARR(3, "ACCEPT_ARR", "接到货物"),
    WAIT_MARK(4, "WAIT_MARK", "待评分"),
    SUCC(5, "SUCC", "已完成"),
    CANCEL(6, "CANCEL", "已取消"),
    ADMIN_CLOSE(7, "ADMIN_CLOSE", "关闭"),
    ;

    PublishOrderStatusEnum(int index, String code, String desc) {
        this.index = index;
        this.code = code;
        this.desc = desc;
    }

    private static final Map<String, String> codeDescMap = new HashedMap();
    private static final Map<String, PublishOrderStatusEnum> codeEnumMap = new HashedMap();

    static {
        for (PublishOrderStatusEnum item : PublishOrderStatusEnum.values()) {
            codeDescMap.put(item.getCode(), item.getDesc());
            codeEnumMap.put(item.getCode(), item);
        }
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


    public static String getDescByCode(String  code) {
        return codeDescMap.get(code);
    }

    public static Map<String, String> getIndexDescMap() {
        return codeDescMap;
    }

    public static Map<String, PublishOrderStatusEnum> getCodeEnumMap() {
        return codeEnumMap;
    }
}
