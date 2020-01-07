package org.egg.enums;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;


/**
 * Created by chendatao on 2018/7/27.
 */
public enum  AccountFlowTypeEnum {
    RECHARGE(0, "RECHARGE", "充值"),
    CASH(1, "CASH", "提现"),
    PUBLISH_ORDER(2, "PUBLISH_ORDER", "发布单"),
    ACCEPT_ORDER(3, "ACCEPT_ORDER", "接单"),
    FINISH(4, "FINISH", "结算"),
    REFUND(5, "REFUND", "退款"),
    REM_REWARD(6, "REM_REWARD", "推荐奖励"),
    AGENT_REWARD(7, "AGENT_REWARD", "代理奖励"),
    CASH_FEE(8, "CASH_FEE", "提现服务费"),
    ;

    AccountFlowTypeEnum(int index, String code, String desc) {
        this.index = index;
        this.code = code;
        this.desc = desc;
    }

    private int index;
    private String code;
    private String desc;

    private static final Map<Integer, String> indexDescMap = new HashedMap();

    static {
        for (AccountFlowTypeEnum item : AccountFlowTypeEnum.values()) {
            indexDescMap.put(item.getIndex(), item.getDesc());
        }
    }
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

    public static String getDescByIndex(Integer index) {
        return indexDescMap.get(index);
    }
}
