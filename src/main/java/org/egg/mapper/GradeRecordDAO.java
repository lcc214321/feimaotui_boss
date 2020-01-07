package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.GradeRecord;
import org.egg.model.DO.GradeRecordExample;

import java.util.List;

@Mapper
public interface GradeRecordDAO {
    int countByExample(GradeRecordExample example);

    int deleteByExample(GradeRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GradeRecord record);

    int insertSelective(GradeRecord record);

    List<GradeRecord> selectByExample(GradeRecordExample example);

    GradeRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GradeRecord record, @Param("example") GradeRecordExample example);

    int updateByExample(@Param("record") GradeRecord record, @Param("example") GradeRecordExample example);

    int updateByPrimaryKeySelective(GradeRecord record);

    int updateByPrimaryKey(GradeRecord record);
}