package org.egg.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dataochen
 * @Description
 * @date: 2017/11/7 15:58
 */
public class Test {
    public static void main(String[] args) {
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
        stringStringLinkedHashMap.put("资金流水管理", "1");
        stringStringLinkedHashMap.put("用户信誉分管理", "2");
        stringStringLinkedHashMap.put("优惠券基础信息管理", "3");
        for (Map.Entry<String, String> stringStringEntry : stringStringLinkedHashMap.entrySet()) {
            System.out.println(stringStringEntry.getKey());
        }
    }
}
