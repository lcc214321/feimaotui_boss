package org.egg.enums;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/16 16:27
 */
public enum WeightEnum {
    ONE("ONE", "小包裹", "1.2"),
    TWO("TWO", "大包裹", "2.2"),
    THREE("THREE", "超大包裹", "4.9"),
//    FOUR("FOUR", "20斤以上", "3.98"),
    ;
    private String code;
    private String desc;
    private String price;

    WeightEnum(String code, String desc, String price) {
        this.code = code;
        this.desc = desc;
        this.price = price;
    }
}
