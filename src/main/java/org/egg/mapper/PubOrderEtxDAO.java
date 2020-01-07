package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PubOrderEtxDAO {
    /**
     * 查询接单列表
     * @param map
     * @return
     */
    public List<Map<String, Object>> queryList4Accept(Map<String, Object> map);
}