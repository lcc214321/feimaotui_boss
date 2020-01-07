package org.egg.model.VO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cdt
 * @Description 我的接单列表页实体
 * @date: 2018/3/2 18:14
 */
public class AcceptListRes implements Serializable {
    private String acceptOrderNo;
    // 接单成功 1：已结单 2.成功结束 3.逾期3天结束 @See AcceptOrderStatusEnum
    private Integer orderStatus;
    private String orderStautsStr;
    // 0:英雄联盟 1：王者荣耀
    private Integer gameType;
    private String gameTypeStr;

    private Integer gameDistrict;
    private String gameDistrictStr;

    // 赏金
    private BigDecimal rewardAmount;
    private String accountNo;

    public String getAcceptOrderNo() {
        return acceptOrderNo;
    }

    public void setAcceptOrderNo(String acceptOrderNo) {
        this.acceptOrderNo = acceptOrderNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStautsStr() {
        return orderStautsStr;
    }

    public void setOrderStautsStr(String orderStautsStr) {
        this.orderStautsStr = orderStautsStr;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getGameTypeStr() {
        return gameTypeStr;
    }

    public void setGameTypeStr(String gameTypeStr) {
        this.gameTypeStr = gameTypeStr;
    }

    public Integer getGameDistrict() {
        return gameDistrict;
    }

    public void setGameDistrict(Integer gameDistrict) {
        this.gameDistrict = gameDistrict;
    }

    public String getGameDistrictStr() {
        return gameDistrictStr;
    }

    public void setGameDistrictStr(String gameDistrictStr) {
        this.gameDistrictStr = gameDistrictStr;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "AcceptListRes{" +
                "acceptOrderNo='" + acceptOrderNo + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStautsStr='" + orderStautsStr + '\'' +
                ", gameType=" + gameType +
                ", gameTypeStr='" + gameTypeStr + '\'' +
                ", gameDistrict=" + gameDistrict +
                ", gameDistrictStr='" + gameDistrictStr + '\'' +
                ", rewardAmount=" + rewardAmount +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
