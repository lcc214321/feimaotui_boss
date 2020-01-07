package org.egg.model.DTO;

import java.io.Serializable;

/**
 * 发送支付的附件信息实体
 * json串不能超127个字符
 * Created by chendatao on 2018/7/21.
 */
public class AttachJsonDto implements Serializable {
    private static final long serialVersionUID = -7580358293941555763L;
    /**
     * 平台支付流水的唯一标识
     * account_flow.record_no
     */
    private String recordNo;
//    /**
//     *业务订单号
//     * 发布单号
//     */
//    private String orderNo;
    /**
     *支付流水类型
     * FlowEventTypeEnum.code
     */
    private String payType;
    /**
     *平台用户唯一标识
     */
    private String userNo;

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

//    public String getOrderNo() {
//        return orderNo;
//    }
//
//    public void setOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }


}
