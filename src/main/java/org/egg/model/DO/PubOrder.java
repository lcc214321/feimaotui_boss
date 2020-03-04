package org.egg.model.DO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class PubOrder {
    private Long id;

    private String orderNo;

    private String userNo;

    private String weigth;

    private BigDecimal price;

    private String kdType;

    private String addressGet;
    private String schName;

    private String getLongitude;

    private String getLatitude;

    private String scoNo;

    private String addressServices;

    private String serLongitude;

    private String serLatitude;

    private Date timeDelay;

    private Date createdDate;

    private Date modifiedDate;

    private String status;

    private String confirmCode;

    private String cancelReason;

    private String wuliuNo;

    private String wuliuJson;

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

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth == null ? null : weigth.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getKdType() {
        return kdType;
    }

    public void setKdType(String kdType) {
        this.kdType = kdType == null ? null : kdType.trim();
    }

    public String getAddressGet() {
        return addressGet;
    }

    public void setAddressGet(String addressGet) {
        this.addressGet = addressGet == null ? null : addressGet.trim();
    }

    public String getGetLongitude() {
        return getLongitude;
    }

    public void setGetLongitude(String getLongitude) {
        this.getLongitude = getLongitude == null ? null : getLongitude.trim();
    }

    public String getGetLatitude() {
        return getLatitude;
    }

    public void setGetLatitude(String getLatitude) {
        this.getLatitude = getLatitude == null ? null : getLatitude.trim();
    }

    public String getScoNo() {
        return scoNo;
    }

    public void setScoNo(String scoNo) {
        this.scoNo = scoNo == null ? null : scoNo.trim();
    }

    public String getAddressServices() {
        return addressServices;
    }

    public void setAddressServices(String addressServices) {
        this.addressServices = addressServices == null ? null : addressServices.trim();
    }

    public String getSerLongitude() {
        return serLongitude;
    }

    public void setSerLongitude(String serLongitude) {
        this.serLongitude = serLongitude == null ? null : serLongitude.trim();
    }

    public String getSerLatitude() {
        return serLatitude;
    }

    public void setSerLatitude(String serLatitude) {
        this.serLatitude = serLatitude == null ? null : serLatitude.trim();
    }

    public Date getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(Date timeDelay) {
        this.timeDelay = timeDelay;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode == null ? null : confirmCode.trim();
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public String getWuliuNo() {
        return wuliuNo;
    }

    public void setWuliuNo(String wuliuNo) {
        this.wuliuNo = wuliuNo == null ? null : wuliuNo.trim();
    }

    public String getWuliuJson() {
        return wuliuJson;
    }

    public void setWuliuJson(String wuliuJson) {
        this.wuliuJson = wuliuJson == null ? null : wuliuJson.trim();
    }

}