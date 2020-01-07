package org.egg.model.VO;

import org.egg.model.DO.CreditScoreFlow;

/**
 * Created by chendatao on 2018/7/25.
 */
public class CreditScoreRes extends CreditScoreFlow {
    private String operTypeStr;

    public String getOperTypeStr() {
        return operTypeStr;
    }

    public void setOperTypeStr(String operTypeStr) {
        this.operTypeStr = operTypeStr;
    }
}
