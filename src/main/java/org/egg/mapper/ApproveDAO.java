package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.Approve;
import org.egg.model.DO.ApproveExample;

import java.util.List;

@Mapper
public interface ApproveDAO {
    int countByExample(ApproveExample example);

    int deleteByExample(ApproveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Approve record);

    int insertSelective(Approve record);

    List<Approve> selectByExample(ApproveExample example);

    Approve selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Approve record, @Param("example") ApproveExample example);

    int updateByExample(@Param("record") Approve record, @Param("example") ApproveExample example);

    int updateByPrimaryKeySelective(Approve record);

    int updateByPrimaryKey(Approve record);
}