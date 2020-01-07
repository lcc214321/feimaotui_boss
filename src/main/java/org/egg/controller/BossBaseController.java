package org.egg.controller;

import org.egg.model.DO.BossUser;
import org.egg.utils.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dataochen
 * @Description
 * @date: 2020/1/3 20:29
 */

public class BossBaseController {
    public BossUser getAccount(HttpServletRequest request) {
        Object account = request.getSession().getAttribute(ConstantsUtil.BOSS_USER_KEY);
        if (account == null) {
            return null;
        }
        BossUser user = (BossUser) account;
        return user;
    }
}
