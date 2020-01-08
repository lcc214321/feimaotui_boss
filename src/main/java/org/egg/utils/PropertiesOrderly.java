package org.egg.utils;

import java.util.*;

/**
 * @author dataochen
 * @Description
 * @date: 2020/1/8 15:16
 */
public class PropertiesOrderly extends Properties {
    private final LinkedHashMap<Object,Object> map = new LinkedHashMap<Object,Object> ();


    @Override
    public Object put(Object key, Object value) {
        map.put(key, value);
        return super.put(key, value);
    }

    public LinkedHashMap<Object, Object> getMap() {
        return map;
    }
}
