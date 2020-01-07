package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.SmsRecord;
import org.egg.model.DO.SmsRecordExample;

import java.util.List;

@Mapper
public interface SmsRecordDAO {
    int countByExample(SmsRecordExample example);

    int deleteByExample(SmsRecordExample example);

    int insert(SmsRecord record);

    int insertSelective(SmsRecord record);

    List<SmsRecord> selectByExample(SmsRecordExample example);

    int updateByExampleSelective(@Param("record") SmsRecord record, @Param("example") SmsRecordExample example);

    int updateByExample(@Param("record") SmsRecord record, @Param("example") SmsRecordExample example);
}