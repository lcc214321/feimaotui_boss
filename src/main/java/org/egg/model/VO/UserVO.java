package org.egg.model.VO;

import org.egg.model.DO.User;

/**
 * Created by chendatao on 2018/7/25.
 */
public class UserVO extends User {
    private String userStatusStr;
    private String realStatusStr;


    public String getUserStatusStr() {
        return userStatusStr;
    }

    public void setUserStatusStr(String userStatusStr) {
        this.userStatusStr = userStatusStr;
    }

    public String getRealStatusStr() {
        return realStatusStr;
    }

    public void setRealStatusStr(String realStatusStr) {
        this.realStatusStr = realStatusStr;
    }
}
