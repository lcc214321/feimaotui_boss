package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.PubOrder;
import org.egg.model.DO.PubOrderExample;

import java.util.List;

@Mapper
public interface PubOrderDAO {
    int countByExample(PubOrderExample example);

    int deleteByExample(PubOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PubOrder record);

    int insertSelective(PubOrder record);

    List<PubOrder> selectByExample(PubOrderExample example);

    PubOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PubOrder record, @Param("example") PubOrderExample example);

    int updateByExample(@Param("record") PubOrder record, @Param("example") PubOrderExample example);

    int updateByPrimaryKeySelective(PubOrder record);

    int updateByPrimaryKey(PubOrder record);
}