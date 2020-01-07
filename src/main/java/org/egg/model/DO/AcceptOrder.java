package org.egg.model.DO;

import java.math.BigDecimal;
import java.util.Date;

public class AcceptOrder {
    private Long id;

    private String orderNo;

    private String userNo;

    private String pubOrderNo;

    private Date timeDelay;

    private String cancelReason;

    private BigDecimal amout;

    private BigDecimal pubPrice;

    private String status;

    private Date createdDate;

    private Date finishedDate;

    private Date mofiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getPubOrderNo() {
        return pubOrderNo;
    }

    public void setPubOrderNo(String pubOrderNo) {
        this.pubOrderNo = pubOrderNo == null ? null : pubOrderNo.trim();
    }

    public Date getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(Date timeDelay) {
        this.timeDelay = timeDelay;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public BigDecimal getAmout() {
        return amout;
    }

    public void setAmout(BigDecimal amout) {
        this.amout = amout;
    }

    public BigDecimal getPubPrice() {
        return pubPrice;
    }

    public void setPubPrice(BigDecimal pubPrice) {
        this.pubPrice = pubPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public Date getMofiedDate() {
        return mofiedDate;
    }

    public void setMofiedDate(Date mofiedDate) {
        this.mofiedDate = mofiedDate;
    }
}