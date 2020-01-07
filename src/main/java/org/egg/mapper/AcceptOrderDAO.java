package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.AcceptOrder;
import org.egg.model.DO.AcceptOrderExample;

import java.util.List;

@Mapper
public interface AcceptOrderDAO {
    int countByExample(AcceptOrderExample example);

    int deleteByExample(AcceptOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcceptOrder record);

    int insertSelective(AcceptOrder record);

    List<AcceptOrder> selectByExample(AcceptOrderExample example);

    AcceptOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcceptOrder record, @Param("example") AcceptOrderExample example);

    int updateByExample(@Param("record") AcceptOrder record, @Param("example") AcceptOrderExample example);

    int updateByPrimaryKeySelective(AcceptOrder record);

    int updateByPrimaryKey(AcceptOrder record);
}