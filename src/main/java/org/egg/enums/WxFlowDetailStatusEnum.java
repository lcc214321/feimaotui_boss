package org.egg.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cdt
 * @Description 微信支付流水状态枚举
 * @date: 2018/3/29 21:00
 *    新建单直接是处理中
 */
public enum WxFlowDetailStatusEnum {
    //新建单直接是处理中
    //INIT(0,"初始化"),
    PROCESS(1,"处理中"),
    SUCC(2,"成功"),
    FAIL(3,"失败"),
    ;
    private int index;
    private String desc;
    private static final Map<Integer, String> indexDescMap = new HashMap<>();
    static {
        for (WxFlowDetailStatusEnum wxFlowDetailStatusEnum : WxFlowDetailStatusEnum.values()) {
            indexDescMap.put(wxFlowDetailStatusEnum.getIndex(), wxFlowDetailStatusEnum.getDesc());
        }
    }

    WxFlowDetailStatusEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }
    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    public static Map<Integer, String> getIndexDescMap() {
        return indexDescMap;
    }
}
