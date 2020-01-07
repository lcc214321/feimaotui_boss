package org.egg.model.DO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Approve {
    private Long id;

    private String userNo;

    @NotBlank
    private String stuNo;
    @NotBlank
    private String gender;

    private String telNo;
    @NotBlank
    private String realName;

    private String realIdNo;

    private String stuSchName;

    private String stuAddressL;

    private String stuAddressQ;

    private String status;

    private String remark;

    private Date createdDate;

    private Date modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getRealIdNo() {
        return realIdNo;
    }

    public void setRealIdNo(String realIdNo) {
        this.realIdNo = realIdNo == null ? null : realIdNo.trim();
    }

    public String getStuSchName() {
        return stuSchName;
    }

    public void setStuSchName(String stuSchName) {
        this.stuSchName = stuSchName == null ? null : stuSchName.trim();
    }

    public String getStuAddressL() {
        return stuAddressL;
    }

    public void setStuAddressL(String stuAddressL) {
        this.stuAddressL = stuAddressL == null ? null : stuAddressL.trim();
    }

    public String getStuAddressQ() {
        return stuAddressQ;
    }

    public void setStuAddressQ(String stuAddressQ) {
        this.stuAddressQ = stuAddressQ == null ? null : stuAddressQ.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}