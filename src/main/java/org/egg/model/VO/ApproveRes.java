package org.egg.model.VO;

import org.egg.model.DO.Approve;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/13 16:18
 */
public class ApproveRes extends Approve {
    private String realStatusStr;

    public String getRealStatusStr() {
        return realStatusStr;
    }

    public void setRealStatusStr(String realStatusStr) {
        this.realStatusStr = realStatusStr;
    }
}
