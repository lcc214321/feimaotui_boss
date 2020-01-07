package org.egg.model.DTO;

import org.egg.enums.AccountFlowStatusEnum;
import org.egg.enums.FlowEventTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cdt
 * @Description 支付单更新状态
 * @date: 2018/3/19 15:37
 */
public class FlowEngineUReqDto implements Serializable {
    private static final long serialVersionUID = 3254827796907596865L;

    /**
     * 资金流水操作事件
     */
    private FlowEventTypeEnum flowEventTypeEnum;
    /**
     * 平台流水详情 唯一索引
     */
    private String recordNo;
    /**
     * 发布单号 唯一索引
     */
//    private String orderNo;
    private String accountNo;
    private BigDecimal amount;
    private AccountFlowStatusEnum accountFlowStatusEnum;


    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

//    public String getOrderNo() {
//        return orderNo;
//    }
//
//    public void setOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//    }
//

    public FlowEventTypeEnum getFlowEventTypeEnum() {
        return flowEventTypeEnum;
    }

    public void setFlowEventTypeEnum(FlowEventTypeEnum flowEventTypeEnum) {
        this.flowEventTypeEnum = flowEventTypeEnum;
    }


    public AccountFlowStatusEnum getAccountFlowStatusEnum() {
        return accountFlowStatusEnum;
    }

    public void setAccountFlowStatusEnum(AccountFlowStatusEnum accountFlowStatusEnum) {
        this.accountFlowStatusEnum = accountFlowStatusEnum;
    }
}
