package org.egg.enums;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/4 22:08
 */
public enum SmsTypeEnum {
    VALIDATE_CODE("VALIDATE_CODE");

    SmsTypeEnum(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
