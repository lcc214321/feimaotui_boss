package org.egg.model.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cdt
 * @Description 提现control入参
 * @date: 2018/8/15 14:56
 */
public class CashReqDto implements Serializable {

    private static final long serialVersionUID = -6169727173401387715L;
    private String cashInfo;
    private BigDecimal cashAmount;
    private String loginPwd;

    public String getCashInfo() {
        return cashInfo;
    }

    public void setCashInfo(String cashInfo) {
        this.cashInfo = cashInfo;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
