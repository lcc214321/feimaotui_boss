package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chendatao on 2017/12/8.
 */
public enum ApproveStatusEnum {
    NULL(-1, "", "未实名"),
    INIT(0, "INIT", "申请已受理"),
    SUCC(1, "SUCC", "审批通过"),
    FAIL(2, "FAIL", "审批拒绝"),
    CLOSE(3, "CLOSE", "关闭"),
    ;
    private static final Map<String, ApproveStatusEnum> codeMap = new HashMap<>();
    private static final Map<Integer, String> indexDescMap = new HashMap<>();
    private static final Map<String, String> codeDescMap = new HashMap<>();

    static {
        for (ApproveStatusEnum items : ApproveStatusEnum.values()) {
            codeMap.put(items.getCode(), items);
            indexDescMap.put(items.getIndex(), items.getDesc());
            codeDescMap.put(items.getCode(), items.getDesc());
        }
    }

    ApproveStatusEnum(int index, String code, String desc) {
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
        ApproveStatusEnum acceptOrderStatusEnum = codeMap.get(code);
        return acceptOrderStatusEnum == null ? NULL.getDesc() : acceptOrderStatusEnum.getDesc();

    }

    public static Map<String, ApproveStatusEnum> getCodeMap() {
        return codeMap;
    }

    public static Map<String, String> getCodeDescMap() {
        return codeDescMap;
    }
}
