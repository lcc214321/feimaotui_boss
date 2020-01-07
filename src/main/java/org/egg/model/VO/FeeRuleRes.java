package org.egg.model.VO;

import org.egg.model.DO.FeeRule;

/**
 * Created by chendatao on 2018/7/24.
 */
public class FeeRuleRes extends FeeRule {
    private String ruleTypeStr;
    private String feeTypeStr;

    public String getRuleTypeStr() {
        return ruleTypeStr;
    }

    public void setRuleTypeStr(String ruleTypeStr) {
        this.ruleTypeStr = ruleTypeStr;
    }

    public String getFeeTypeStr() {
        return feeTypeStr;
    }

    public void setFeeTypeStr(String feeTypeStr) {
        this.feeTypeStr = feeTypeStr;
    }
}
