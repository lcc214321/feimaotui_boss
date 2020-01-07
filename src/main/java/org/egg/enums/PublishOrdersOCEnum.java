package org.egg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author cdt
 * @Description
 * @date: 2018/2/26 10:13
 */
public enum PublishOrdersOCEnum {
    NULL("-1","","未知"),
    CREATE_TIME("0","created_date","发布时间"),
    REWARD_TIME("1","reward_amount","悬赏金"),
    ID("2","id","ID"),
    ;
    PublishOrdersOCEnum(String index,String code, String desc) {
        this.index = index;
        this.code = code;
        this.desc = desc;
    }

    private String index;
//    数据库orderby 字段名称
    private String code;
    private String desc;

    public String getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public static PublishOrdersOCEnum getCodeByIndex(String index) {
        if (StringUtils.isBlank(index)) {
            return NULL;
        }
        for (PublishOrdersOCEnum publishOrdersOCEnum : PublishOrdersOCEnum.values()) {
            if (index.equals(publishOrdersOCEnum.getIndex())) {
                return publishOrdersOCEnum;
            }
        }
        return NULL;

    }
}
