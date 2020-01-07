package org.egg.model.VO;

import org.egg.model.DO.AccountFlow;

/**
 * Created by chendatao on 2018/7/25.
 */
public class AccountFlowRes extends AccountFlow {
    private String flowUserTypeStr;
    private String accTypeStr;
    private String recordStatusStr;
    private String recordTypeStr;

    public String getFlowUserTypeStr() {
        return flowUserTypeStr;
    }

    public void setFlowUserTypeStr(String flowUserTypeStr) {
        this.flowUserTypeStr = flowUserTypeStr;
    }

    public String getAccTypeStr() {
        return accTypeStr;
    }

    public void setAccTypeStr(String accTypeStr) {
        this.accTypeStr = accTypeStr;
    }

    public String getRecordStatusStr() {
        return recordStatusStr;
    }

    public void setRecordStatusStr(String recordStatusStr) {
        this.recordStatusStr = recordStatusStr;
    }

    public String getRecordTypeStr() {
        return recordTypeStr;
    }

    public void setRecordTypeStr(String recordTypeStr) {
        this.recordTypeStr = recordTypeStr;
    }
}
