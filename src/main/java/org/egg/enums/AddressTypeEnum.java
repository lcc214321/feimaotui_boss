package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 11:42
 */
public enum AddressTypeEnum {
    NULL(-1, "", "未知"),
    ADDRESS_GET(0, "ADDRESS_GET", "取货地址"),
    ADDRESS_SER(1, "ADDRESS_SER", "送货地址"),
    ;
    private static final Map<String, AddressTypeEnum> codeMap = new HashMap<>();
    private static final Map<Integer, String> indexDescMap = new HashMap<>();

    static {
        for (AddressTypeEnum items : AddressTypeEnum.values()) {
            codeMap.put(items.getCode(), items);
            indexDescMap.put(items.getIndex(), items.getDesc());
        }
    }

    AddressTypeEnum(int index, String code, String desc) {
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
        AddressTypeEnum acceptOrderStatusEnum = codeMap.get(code);
        return acceptOrderStatusEnum == null ? NULL.getDesc() : acceptOrderStatusEnum.getDesc();

    }

    public static Map<String, AddressTypeEnum> getCodeMap() {
        return codeMap;
    }
}
