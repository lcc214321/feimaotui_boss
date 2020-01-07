package org.egg.model.DTO;

import java.io.Serializable;

/**
 * boss登录实体
 * Created by chendatao on 2018/7/26.
 */
public class BossLoginDto implements Serializable {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
