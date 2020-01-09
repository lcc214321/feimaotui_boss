package org.egg.model.VO;

import org.egg.model.DO.BossUser;

/**
 * Created by chendatao on 2018/7/25.
 */
public class BossUserRes extends BossUser {
    private String userStatusStr;
    private String levelStr;

    public String getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getUserStatusStr() {
        return userStatusStr;
    }

    public void setUserStatusStr(String userStatusStr) {
        this.userStatusStr = userStatusStr;
    }
}
