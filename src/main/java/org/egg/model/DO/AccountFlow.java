package org.egg.model.DO;/* https://github.com/cdt */

import lombok.Data;
import org.egg.enums.AccountFlowStatusEnum;
import org.egg.enums.AccountFlowTypeEnum;
import org.egg.enums.FlowUserTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cdt
 * date:2018/03/16 19:32
 */
@Data
public class AccountFlow implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 4660125202581970007L;

    private Long id;

    private String recordNo;
    /**
     * @see FlowUserTypeEnum
     */
    private Integer flowUserType;
    private String orderNo;

    // 总余额 元
    private BigDecimal totalMoney;
    /**
     * 实际支付金额
     */
    private BigDecimal payAmount;
    /**
     * 优惠券优惠的金额
     */
    private BigDecimal couponAmount;
    /**
     * 优惠券的id
     */
    private String couponId;

    // 账户
    private String userNo;

    private Date createdDate;

    private Date modifiedDate;

    // 账号类型 0：个人 1：平台
    private Integer accType;
    //0:init 1:process 2.succ 3.fail
    /**
     * @see AccountFlowStatusEnum
     */
    private Integer recordStatus;
    private Integer version;
//    流水类型 0：充值 1：提现 2：发布单 3：接单 4：结算
    /**
     * @see AccountFlowTypeEnum
     */
    private Integer recordType;
//    备用字段 提现信息
    private String remark;


}