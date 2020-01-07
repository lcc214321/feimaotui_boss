package org.egg.model.DO;

import java.math.BigDecimal;
import java.util.Date;

public class FeeRule extends FeeRuleKey {
    private BigDecimal feeThresholdValue;

    private BigDecimal feeValue;

    private Date createdDate;

    private Date modifiedDate;

    private Integer version;

    public BigDecimal getFeeThresholdValue() {
        return feeThresholdValue;
    }

    public void setFeeThresholdValue(BigDecimal feeThresholdValue) {
        this.feeThresholdValue = feeThresholdValue;
    }

    public BigDecimal getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(BigDecimal feeValue) {
        this.feeValue = feeValue;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}