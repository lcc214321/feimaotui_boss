package org.egg.enums;

import java.math.BigDecimal;

/**
 * 信誉分来源枚举
 *0：增加 1：扣减
 * Created by chendatao on 2018/7/26.
 */
public enum CreditScoreSourceTypeEnum {
    PUB_PAY_SUCC(new BigDecimal("0.1"), "PUB_PAY_SUCC", 0, "发单支付成功增加"),
    ACCEPT_SUCC(new BigDecimal("0.1"), "ACCEPT_SUCC", 0, "接单成功增加"),
//    RECHARGE_SUCC(new BigDecimal("0.1"), "RECHARGE_SUCC", 0, "充值支付成功增加"),
//    NORMAL_FINISH(new BigDecimal("0.1"), "NORMAL_FINISH", 0, "正常结算增加"),
    DELAY(new BigDecimal("5"), "DELAY", 1, "逾期扣减"),
//    FOUL(BigDecimal.ZERO, "FOUL", 1, "违约扣减"),
//    CASH(new BigDecimal("20"), "CASH", 1, "提现扣减"),
    REC(BigDecimal.ZERO, "REC", 0, "推荐奖励"),
    ;

    /**
     * 基数
     */
    private BigDecimal baseNumber;
    private String code;
    private Integer operaType;
    private String desc;

    CreditScoreSourceTypeEnum(BigDecimal baseNumber, String code, Integer operaType, String desc) {
        this.baseNumber = baseNumber;
        this.code = code;
        this.operaType = operaType;
        this.desc = desc;
    }

    public BigDecimal getBaseNumber() {
        return baseNumber;
    }

    public String getCode() {
        return code;
    }

    public Integer getOperaType() {
        return operaType;
    }

    public String getDesc() {
        return desc;
    }
}
