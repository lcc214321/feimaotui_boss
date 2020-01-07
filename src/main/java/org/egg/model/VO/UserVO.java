package org.egg.model.VO;

import org.egg.model.DO.BossUser;

/**
 * Created by chendatao on 2018/7/25.
 */
public class UserVO extends BossUser {
    private String userStatusStr;


    public String getUserStatusStr() {
        return userStatusStr;
    }

    public void setUserStatusStr(String userStatusStr) {
        this.userStatusStr = userStatusStr;
    }
}
